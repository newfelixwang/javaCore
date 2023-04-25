package com.wang.userapp.service;

import com.wang.userapp.domain.TUserCoupon;
import com.wang.userapp.mapper.TUserCouponMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：wp
 * @Package：com.wang.userapp.service
 * @Project：java-Core
 * @name：CouponService
 * @Date：2023/3/15 17:41
 * @Filename：CouponService
 */
@Service
public class UserService {

    @Resource
    private TUserCouponMapper tUserCouponMapper;


    public void print() {
        System.out.println("###");
    }

    public TUserCoupon getuserById(Integer id) {

        TUserCoupon tUserCoupon = tUserCouponMapper.selectByPrimaryKey(id);
        return tUserCoupon;
    }

}
