package com.wang.couponapp.controller;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

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

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        Map map1 = new HashMap();
        map1.put("1","");
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");

        AtomicInteger atomicInteger = new AtomicInteger(2);
        atomicInteger.compareAndSet(1,3);

        OAuth2ResourceServerProperties.Jwt jwt = new OAuth2ResourceServerProperties.Jwt();

        return "111";
    }

    public static void main(String[] args) {
        final String s1 = "xdclass";
        String s2 = s1 + ".net";
        String s3 = "xdclass"+".net";
        System.out.println(s2==s3);
        LinkedList linkedList = new LinkedList();
        linkedList.add("");
        System.out.println(s3=="xdclass.net");
    }

}
