package com.wang.userapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wp
 * @ClassName UserAppApplication
 * @description: TODO
 * @datetime 2023年 03月 29日 6:57
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.wang.userapp.mapper")
public class UserAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAppApplication.class, args);
    }
}
