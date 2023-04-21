package com.wang.couponapp.service;


import com.wang.couponapp.domain.TCoupon;
import com.wang.userserviceapi.vo.UserVO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.service
 * @Project：java-Core
 * @name：CouponService
 * @Date：2023/3/15 17:41
 * @Filename：CouponService
 */
public interface CouponService {

    void print();

    List<TCoupon> getCouponList() throws ExecutionException;

    UserVO getByUserId(Integer id);

    void updateCoupon();

}
