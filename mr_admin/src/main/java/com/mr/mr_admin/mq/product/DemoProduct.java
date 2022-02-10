package com.mr.mr_admin.mq.product;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class DemoProduct {

    @Value("${rocketmq.servername}")
    private String serverName;

    @Value("${rocketmq.defaultname}")
    private String defaultName;

    public DefaultMQProducer getRocketClient(){
        DefaultMQProducer producer = new DefaultMQProducer(defaultName);

        producer.setNamesrvAddr(serverName);
        return producer;
    }

    public void testSendMessage(){
        DefaultMQProducer producer = getRocketClient();

        try {
            producer.start();

            Message msg = new Message("demo1906test", "for test", "hello word".getBytes(RemotingHelper.DEFAULT_CHARSET));

            producer.send(msg);

            producer.shutdown();
        } catch (MQClientException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }

    }
}
