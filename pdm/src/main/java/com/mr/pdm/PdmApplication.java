package com.mr.pdm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDubboConfiguration
@MapperScan("com.mr.pdm.mapper")
public class PdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdmApplication.class, args);
    }

}
