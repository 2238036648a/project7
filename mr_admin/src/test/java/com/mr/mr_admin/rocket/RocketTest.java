package com.mr.mr_admin.rocket;

import com.mr.mr_admin.mq.consumer.DemoConsumer;
import com.mr.mr_admin.mq.product.DemoProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RocketTest {

    @Autowired
    private DemoProduct demoProduct;

    @Autowired
    private DemoConsumer demoConsumer;

    @Test
    public void testSend(){
        demoProduct.testSendMessage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demoConsumer.testConsumer();
    }
}
