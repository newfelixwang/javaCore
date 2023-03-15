package com.wang.couponapp.service;

import org.springframework.stereotype.Service;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.service
 * @Project：java-Core
 * @name：CouponServiceImpl
 * @Date：2023/3/15 17:41
 * @Filename：CouponServiceImpl
 */

@Service
public class CouponServiceImpl implements CouponService{


    @Override
    public void print() {
        System.out.println("###");
    }
}
