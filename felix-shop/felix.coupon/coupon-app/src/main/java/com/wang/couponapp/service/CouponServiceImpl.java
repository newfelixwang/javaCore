package com.wang.couponapp.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wang.couponapp.constant.Constant;
import com.wang.couponapp.domain.TCoupon;
import com.wang.couponapp.domain.TCouponExample;
import com.wang.couponapp.mapper.TCouponMapper;
import com.wang.userserviceapi.service.IUserService;
import com.wang.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Reference
    private IUserService userService;

    LoadingCache<Integer, List<TCoupon>> couponCache = CacheBuilder.newBuilder().expireAfterAccess(Constant.CacheTime.COUPON_TIME, TimeUnit.MILLISECONDS).build(
            new CacheLoader<Integer, List<TCoupon>>() {
                @Override
                public List<TCoupon> load(Integer integer) throws Exception {
                    return loadCoupon(integer);
                }
            }
    );


    LoadingCache<Integer, TCoupon> couponIdsCache = CacheBuilder.newBuilder().expireAfterAccess(Constant.CacheTime.COUPON_TIME, TimeUnit.MILLISECONDS).build(
            new CacheLoader<Integer, TCoupon>() {
                @Override
                public TCoupon load(Integer integer) throws Exception {
                    return loadIdCoupon(integer);
                }
            }
    );


    @Override
    public void print() {
        System.out.println("###");
    }

    /**
     * 查询所有优惠券
     *
     * @return
     */
    @Override
    public List<TCoupon> getCouponList() {


        return tCouponMapper.selectByExample(new TCouponExample());
    }

    private TCoupon loadIdCoupon(Integer o) {
        TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(o);
        return tCoupon;
    }


    private List<TCoupon> loadCoupon(Integer o) {
        TCouponExample example = new TCouponExample();
        TCouponExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Constant.USERFULL);
        criteria.andStartTimeLessThan(new Date());
        criteria.andEndTimeGreaterThan(new Date());
        List<TCoupon> tCoupons = tCouponMapper.selectByExample(example);
        return tCoupons;
    }


    @Override
    public UserVO getByUserId(Integer id) {
        UserVO user = userService.getByUserId(id);
        return user;
    }


}
