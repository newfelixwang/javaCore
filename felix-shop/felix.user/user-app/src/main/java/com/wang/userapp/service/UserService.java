package com.wang.userapp.service;

import com.wang.userapp.domain.TUserCoupon;

/**
 * @Author：wp
 * @Package：com.wang.userapp.service
 * @Project：java-Core
 * @name：CouponService
 * @Date：2023/3/15 17:41
 * @Filename：CouponService
 */
public interface UserService {

    void print();

    TUserCoupon getuserById(Integer id);
}
