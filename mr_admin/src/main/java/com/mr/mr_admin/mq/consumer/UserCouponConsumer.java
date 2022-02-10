package com.mr.mr_admin.mq.consumer;

import com.mr.mr_common.common.CommonConstants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCouponConsumer {

    @Value("${rocketmq.servername}")
    private String serverName;

    @Value("${rocketmq.defaultname}")
    private String defaultName;

    public DefaultMQPushConsumer getRocketConsumer(){
        DefaultMQPushConsumer producer = new DefaultMQPushConsumer(defaultName);

        producer.setNamesrvAddr(serverName);

        return producer;
    }

    public void testConsumer() {
        DefaultMQPushConsumer consumer = getRocketConsumer();

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
                MessageExt messageExt = msgs.get(0);
                System.out.println("2222222222"+messageExt);
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
