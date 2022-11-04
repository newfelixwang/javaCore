package com.project.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wp
 * @ClassName TestController
 * @description: 测试类
 * @datetime 2022年 11月 05日 0:11
 * @version: 1.0
 */

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test1(){
        return "str"+new Date();
    }
}
