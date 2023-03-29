package com.wang.userapp.service;

import com.wang.userapp.domain.TUserCoupon;
import com.wang.userapp.domain.TUserCouponExample;
import com.wang.userapp.mapper.TUserCouponMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：wp
 * @Package：com.wang.userapp.service
 * @Project：java-Core
 * @name：CouponServiceImpl
 * @Date：2023/3/15 17:41
 * @Filename：CouponServiceImpl
 */

@Service
public class UserServiceImpl implements com.wang.userapp.service.UserService {


    @Resource
    private TUserCouponMapper tUserCouponMapper;

    @Override
    public void print() {
        System.out.println("###");
    }

    @Override
    public TUserCoupon getuserById(Integer id) {

        TUserCoupon tUserCoupon = tUserCouponMapper.selectByPrimaryKey(id);
        return tUserCoupon;
    }
}
