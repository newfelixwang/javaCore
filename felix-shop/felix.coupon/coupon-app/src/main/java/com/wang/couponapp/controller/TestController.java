package com.wang.couponapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wp
 * @ClassName TestController
 * @description: TODO
 * @datetime 2023年 02月 26日 19:36
 * @version: 1.0
 */
@RestController
public class TestController {


    @RequestMapping("/test")
    public String test(){
        return "111";
    }


}
