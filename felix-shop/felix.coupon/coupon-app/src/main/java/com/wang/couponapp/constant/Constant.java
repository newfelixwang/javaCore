package com.wang.couponapp.constant;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.constant
 * @Project：java-Core
 * @name：Constant
 * @Date：2023/4/13 14:31
 * @Filename：Constant
 */
public class Constant {

    public static final int USERFULL = 0;

    public static final int USERLESS = 1;


    public interface CacheTime {

        //优惠券缓存时间
        int COUPON_CACHE_TIME = 10;

        //优惠券刷新时间
        int COUPON_REFRESH_TIME = 5;
    }
}
