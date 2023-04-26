package com.wang.couponapp;

import com.wang.couponapp.domain.TCoupon;
import com.wang.couponapp.domain.TCouponExample;
import com.wang.couponapp.mapper.TCouponMapper;
import com.wang.couponapp.service.CouponService;
import com.wang.couponserviceapi.dto.UserCouponDto;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class CouponAppApplicationTests {


    @Resource
    private CouponService couponService;

    @Resource
    private TCouponMapper tCouponMapper;

    @Resource
    private RedisTemplate redisTemplate;

//    @Resource
//    private RedissonClient redissonClient;

//    @Resource
//    private JedisPool jedisPool;

//    @Resource
//    private Jedis jedis;

    @Test
    public void contextLoads() {
        couponService.print();
        System.err.println("hello world");
    }

    @Test
    public void insert() {
        for (int i = 0; i < 100000; i++) {
            TCoupon tCoupon = new TCoupon();
            tCoupon.setAchieveAmount(500);
            tCoupon.setReduceAmount(20);
            tCoupon.setCreateTime(new Date());
            tCoupon.setCode(UUID.randomUUID().toString());
            tCoupon.setPicUrl("1.jpg");
            tCoupon.setStatus(0);
            tCoupon.setStock(100);
            tCoupon.setTitle("测试coupon");
            tCouponMapper.insert(tCoupon);
        }

    }

    @Test
    public void delete() {
        tCouponMapper.deleteByPrimaryKey(7);
    }

    @Test
    public void update() {
        TCoupon tCoupon = new TCoupon();
        tCoupon.setId(8);
        tCoupon.setCode("9527");
        tCouponMapper.updateByPrimaryKey(tCoupon);
    }


    @Test
    public void select() {
        // select * from t_coupon where code = "00415d96-49bd-4cce-83e3-08302b9aa084" and status=0 and achieve_amount between (100,1000) and title not like '%111%';
        TCouponExample example = new TCouponExample();
        example.createCriteria().andCodeEqualTo("fd7911b8-81e5-4dac-bdbe-b666e684390e").andStatusEqualTo(0)
                .andAchieveAmountBetween(100, 1000).andTitleNotLike("111");
        List<TCoupon> tCoupon = tCouponMapper.selectByExample(example);
        System.err.println(tCoupon);
    }


    @Test
    public void testSaveCoupon() {
        UserCouponDto dto = new UserCouponDto();
        dto.setUserId(123);
        dto.setCouponId(1);
        dto.setOrderId(10086);
        couponService.saveUserCoupon(dto);
    }

    //比較 redistemplate  Jedis  redisson
    @Test
    public void testRedistemplate() {
        redisTemplate.opsForValue().set("hhhh", "ffff");
        Object a = redisTemplate.opsForValue().get("hhhh");
        System.err.println(a);
    }

//    @Test
//    public void testJedis() {
//        Jedis jedis = jedisPool.getResource();
//        jedis.set("a", "1");
//        String a = jedis.get("a");
//
//        Long aa = jedis.setnx("aa", "");
//        System.err.println(aa);
//        System.err.println(a);
//    }

//    @Test
//    public void testRedissonClient() {
//
//        RLock lock = redissonClient.getLock("bb");
//        lock.lock();
//        lock.unlock();
//        System.err.println("rrrrr");
//    }


    @Test
    public void testRedis() throws InterruptedException {
        redisTemplate.opsForValue().set("wang", "w");
        System.out.println(redisTemplate.opsForValue().get("wang"));
        Thread thread = Thread.currentThread();
        thread.sleep(300);
        redisTemplate.delete("wang");
        System.out.println("delete");
    }


    @Test
    public void testSortList() {
        ZSetOperations zSet = redisTemplate.opsForZSet();
        zSet.add("COUPON","DI:1",1);
        zSet.add("COUPON","DI:2",2);
        zSet.add("COUPON","DI:3",3);
        zSet.add("COUPON","DI:4",4);

        //从row 加入的时候，才是输出所有参数
        Set coupon = zSet.range("COUPON", 0, -1);
        coupon.stream().forEach(System.out::println);
        zSet.incrementScore("COUPON","DI:4",2);

        zSet.incrementScore("COUPON","DI:1",1);

        Set coupon1 = zSet.rangeByScore("COUPON", 0, -1);
        coupon1.stream().forEach(System.out::println);

        Set coupon2 = redisTemplate.opsForZSet().range("COUPON", 0, 2);
        coupon2.stream().forEach(System.out::println);

        redisTemplate.opsForZSet().remove("COUPON","DI:1");
    }

}
