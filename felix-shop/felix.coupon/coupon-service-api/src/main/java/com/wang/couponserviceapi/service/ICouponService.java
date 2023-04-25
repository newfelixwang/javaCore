package com.wang.couponserviceapi.service;

import com.wang.couponserviceapi.dto.TCouponDto;
import com.wang.couponserviceapi.dto.UserCouponDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author：wp
 * @Package：com.wang.couponserviceapi.service
 * @Project：java-Core
 * @name：ICouponService
 * @Date：2023/4/25 10:09
 * @Filename：ICouponService
 */
public interface ICouponService {

    /**
     * 保存用户优惠券
     * @param dto
     * @return
     */
    String saveUserCoupon(UserCouponDto dto);


    List<TCouponDto> getCouponList()  throws ExecutionException;

}
