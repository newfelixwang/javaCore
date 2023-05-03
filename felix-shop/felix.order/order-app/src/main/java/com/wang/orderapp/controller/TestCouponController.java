package com.wang.orderapp.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author：wp
 * @Package：com.wang.orderapp.controller
 * @Project：java-Core
 * @name：TestCouponController
 * @Description 优惠券功能模拟实现
 * @Date：2023/5/3 11:24
 * @Filename：TestCouponController
 */
@RestController
@RequestMapping(value = "/coupon")
public class TestCouponController {


    private static Map coupMap = new ConcurrentHashMap<>();


    @Resource
    private RedisTemplate redisTemplate;

    private static final String COUPON = "COUPON";


    @GetMapping("/insertCoupon/{num}")
    public String putCoupon(@PathVariable("num") Integer num) {
        for (int i = 0; i < num; i++) {
            String couponid = UUID.randomUUID().toString();
            coupMap.put(couponid, couponid);
            redisTemplate.opsForZSet().add(COUPON, couponid, new Random().nextInt(20));
        }
        return "增加优惠券个数" + num;
    }

    @GetMapping("/sortCoupon")
    public String sortCoupon() {
        Iterator<Map.Entry<String, String>> iterator = coupMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            int i = new Random().nextInt(100);
            redisTemplate.opsForZSet().incrementScore(COUPON, key, i);
            System.out.println("couponid " + key + "的score新增" + i);
        }
        redisTemplate.opsForZSet().range(COUPON, 0, -1);
        return "sortCoupon";
    }

}
