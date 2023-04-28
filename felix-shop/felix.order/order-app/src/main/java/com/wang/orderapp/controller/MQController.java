package com.wang.orderapp.controller;

import com.wang.orderapp.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：wp
 * @Package：com.wang.orderapp.controller
 * @Project：java-Core
 * @name：MQController
 * @Date：2023/4/27 20:23
 * @Filename：MQController
 */
@RestController
public class MQController {

    @Resource
    private OrderService orderService;


    @GetMapping("/MQ")
    public String testMQ(){
        orderService.sendMSG();
        return "success";
    }

}
