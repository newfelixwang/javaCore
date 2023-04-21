package com.wang.couponapp.job;

import com.wang.couponapp.service.CouponService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.job
 * @Project：java-Core
 * @name：TestJobHandle
 * @Date：2023/4/20 17:35
 * @Filename：TestJobHandle
 */

@Service
public class TestJobHandle {


    Logger logger = LoggerFactory.getLogger(TestJobHandle.class);

    @Resource
    private CouponService couponService;

    //秒 分  时 日 月 年
    @Scheduled(cron = "0/5 * * * * ?")
    private void test() {
        logger.info("定時任務");
        couponService.updateCoupon();
    }

}
