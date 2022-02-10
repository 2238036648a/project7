package com.mr.bizdiscount.mq;

import com.alibaba.fastjson.JSON;
import com.mr.bizdiscount.dto.CouponDto;
import com.mr.bizdiscount.dto.UserCouponDTO;
import com.mr.bizdiscount.mapper.CouponMapper;
import com.mr.bizdiscount.mapper.UserCouponMapper;
import com.mr.bizdiscount.vo.CouponVO;
import com.mr.mr_common.common.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class UserCouponConsumer {

    @Resource
    private UserCouponMapper userCouponMapper;

    @Resource
    private CouponMapper couponMapper;


    public  UserCouponConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("userCoupon");

        consumer.setNamesrvAddr("localhost:9876");

        try {
            consumer.subscribe(CommonConstants.PRODUCER_TOPIC_USERCOUPON, "*");
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

                    UserCouponDTO uc = JSON.toJavaObject((JSON) retMap.get("uc"), UserCouponDTO.class);
                    CouponVO couponVo = JSON.toJavaObject((JSON) retMap.get("coupon"), CouponVO.class);
                    System.out.println("3333333333333333333333"+couponVo);
                    couponMapper.updatecouponInfo(couponVo);
                    userCouponMapper.insertInfo(uc);
                } catch (Exception e) {
                    log.error("userConpon consumer 处理数据异常",e);
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
