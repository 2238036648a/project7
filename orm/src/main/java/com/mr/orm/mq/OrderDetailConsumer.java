package com.mr.orm.mq;

import com.alibaba.fastjson.JSON;
import com.mr.mr_common.common.CommonConstants;
import com.mr.mr_common.dto.OrderDetailDto;
import com.mr.mr_common.dto.OrderMainDto;
import com.mr.orm.mapper.OrderDetailDtoMapper;
import com.mr.orm.mapper.OrderMainDtoMapper;
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
public class OrderDetailConsumer {

    @Resource
    private OrderDetailDtoMapper orderDetailDtoMapper;

    @Resource
    private OrderMainDtoMapper orderMainDtoMapper;
    public OrderDetailConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderDatail");

        consumer.setNamesrvAddr("localhost:9876");

        try {
            consumer.subscribe(CommonConstants.ORDER_DETAIL_TOPIC, "*");
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

                    OrderMainDto orderMainDto = JSON.toJavaObject((JSON) retMap.get("orderMainDetail"), OrderMainDto.class);
                    OrderDetailDto orderDetailDto = JSON.toJavaObject((JSON) retMap.get("orderDetail"), OrderDetailDto.class);
                    int i = orderMainDtoMapper.insertSelective(orderMainDto);
                    int status = orderDetailDtoMapper.insert(orderDetailDto);

                } catch (Exception e) {
                    log.error("orderDetail consumer 处理数据异常",e);
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
