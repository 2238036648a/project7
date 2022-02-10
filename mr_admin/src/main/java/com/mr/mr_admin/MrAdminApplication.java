package com.mr.mr_admin;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableDubboConfig
@MapperScan("com.mr.mr_admin.mapper")
public class MrAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrAdminApplication.class, args);
    }

}
