package com.wang.orderapp;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wp
 * @ClassName OrderAppApplication
 * @description: 用户服务启动类
 * @datetime 2023年 03月 29日 6:57
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.wang.orderapp.mapper")
@EnableDubboConfig
@DubboComponentScan({"com.wang.orderapp.service.dubbo","com.wang.couponapp.service"})
public class OrderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAppApplication.class, args);
    }
}
