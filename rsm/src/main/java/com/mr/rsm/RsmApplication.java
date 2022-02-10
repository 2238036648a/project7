package com.mr.rsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsmApplication.class, args);
    }

}
