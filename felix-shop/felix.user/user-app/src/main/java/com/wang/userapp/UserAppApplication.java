package com.wang.userapp;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wp
 * @ClassName UserAppApplication
 * @description: 用户服务启动类
 * @datetime 2023年 03月 29日 6:57
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.wang.userapp.mapper")
@EnableDubboConfig
@DubboComponentScan("com.wang.userapp.service.dubbo")
public class UserAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAppApplication.class, args);
    }
}
