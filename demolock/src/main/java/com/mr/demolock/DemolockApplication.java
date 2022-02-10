package com.mr.demolock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemolockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemolockApplication.class, args);
    }

}
