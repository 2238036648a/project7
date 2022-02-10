package com.mr.bizdiscount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.mr.bizdiscount.mapper")
public class BizdiscountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizdiscountApplication.class, args);
    }

}
