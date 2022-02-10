package com.mr.pdm.mq;

import com.alibaba.fastjson.JSON;
import com.mr.mr_common.common.CommonConstants;
import com.mr.pdm.mapper.PdStorageMapper;
import com.mr.pdm.mapper.ProductMapper;
import com.mr.pdm.vo.ProductStorageVO;
import com.mr.pdm.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ProductConsumer {

    @Resource
    private PdStorageMapper StorageMapper;

    @Resource
    private ProductMapper productMapper;

    public ProductConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("storageCoupon");

        consumer.setNamesrvAddr("localhost:9876");

        try {
            consumer.subscribe(CommonConstants.PRODUCT_STORAGE, "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                try {
                    MessageExt messageExt = msgs.get(0);
                    byte[] bytes = messageExt.getBody();
                    String recString = new String(bytes);
                    Map retMap = (Map) JSON.parse(recString);

                    //查询商品信息
                    ProductVO pdId = productMapper.findProductById((String) retMap.get("pdId"));
                    int buyNum = (int) retMap.get("buyNum");
                    ProductStorageVO storageVO = new ProductStorageVO();
//                    if(pdId.getPdStorage() > buyNum){
                        int i = pdId.getPdStorage() - buyNum;
                       storageVO.setPdStorage(i);
                       storageVO.setPdId(pdId.getPdId());
                        int status = StorageMapper.updateByStorage(storageVO);
                 /*   }*/
                   /* List<ProductStorageVO> result1 =  StorageMapper.findStorage((String) retMap.get("pdId"));
                    //获取购买数量
                    int buyNum = (int) retMap.get("buyNum");
                    for (ProductStorageVO result:result1) {
                        if(result.getPdStorage() > buyNum){
                            int i = result.getPdStorage() - buyNum;
                            result.setPdStorage(i);
                            int status = StorageMapper.updateByStorage(result);
                        }
                    }*/
                } catch (Exception e) {
                    log.error("productStorage consumer 处理数据异常",e);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;

                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //Launch the consumer instance.
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        System.out.printf("Consumer Started.%n");
    }

}
