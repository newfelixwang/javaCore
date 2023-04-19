package com.wang.couponapp.service;

import com.wang.couponapp.domain.TCoupon;
import com.wang.couponapp.domain.TCouponExample;
import com.wang.couponapp.mapper.TCouponMapper;
import com.wang.userserviceapi.service.IUserService;
import com.wang.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.service
 * @Project：java-Core
 * @name：CouponServiceImpl
 * @Date：2023/3/15 17:41
 * @Filename：CouponServiceImpl
 */

@Service
public class CouponServiceImpl implements CouponService {


    @Resource
    private TCouponMapper tCouponMapper;

    @Reference(version = "1.0.0",group = "user-info")
    private IUserService userService;

    @Override
    public void print() {
        System.out.println("###");
    }

    /**
     * 查询所有优惠券
     * @return
     */
    @Override
    public List<TCoupon> getCouponList() {
        return tCouponMapper.selectByExample(new TCouponExample());
    }

    @Override
    public UserVO getByUserId(Integer id) {
        UserVO user = userService.getByUserId(id);
        return user;
    }


}
