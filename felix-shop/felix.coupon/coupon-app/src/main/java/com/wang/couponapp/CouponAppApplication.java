package com.wang.couponapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wang.couponapp.mapper")
public class CouponAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponAppApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行JVM ShutdownHook");
            }
        }));
    }

}
