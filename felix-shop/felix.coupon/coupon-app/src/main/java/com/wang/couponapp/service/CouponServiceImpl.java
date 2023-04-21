package com.wang.couponapp.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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


    private Map couponMap = new ConcurrentHashMap();


    LoadingCache<Integer, List<TCoupon>> couponCache = CacheBuilder.newBuilder().
            expireAfterAccess(Constant.CacheTime.COUPON_CACHE_TIME, TimeUnit.MILLISECONDS).
            refreshAfterWrite(Constant.CacheTime.COUPON_REFRESH_TIME, TimeUnit.MILLISECONDS).build(
                    new CacheLoader<Integer, List<TCoupon>>() {
                        @Override
                        public List<TCoupon> load(Integer integer) throws Exception {
                            return loadCoupon(integer);
                        }
                    }
            );



    LoadingCache<Integer, TCoupon> couponIdsCache = CacheBuilder.newBuilder().
            expireAfterAccess(Constant.CacheTime.COUPON_CACHE_TIME, TimeUnit.MILLISECONDS).
            refreshAfterWrite(Constant.CacheTime.COUPON_REFRESH_TIME, TimeUnit.MILLISECONDS).build(
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
    public List<TCoupon> getCouponList() throws ExecutionException {
        couponCache.get(1);
        ConcurrentMap<Integer, List<TCoupon>> integerListConcurrentMap = couponCache.asMap();
        List<TCoupon> tCoupons = integerListConcurrentMap.get(1);

        return tCouponMapper.selectByExample(new TCouponExample());
    }

    private TCoupon loadIdCoupon(Integer o) {
        TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(o);
        return tCoupon;
    }


    public List<TCoupon> getCouponListByIds(String ids) {
        String[] idStr = ids.split(",");
        List<Integer> loadFromDB = Lists.newArrayList();
        List<TCoupon> tCoupons = Lists.newArrayList();
        List<String> idList = Lists.newArrayList(idStr);
        for (String id : idList) {
            TCoupon tCoupon = couponIdsCache.getIfPresent(id);
            if (tCoupon == null) {
                loadFromDB.add(Integer.parseInt(id));
            } else {
                tCoupons.add(tCoupon);
            }
        }
        List<TCoupon> tCoupons1 = couponByIds(loadFromDB);
        Map<Integer, TCoupon> tCouponMap = tCoupons1.stream().collect(
                Collectors.toMap(TCoupon::getId, TCoupon -> TCoupon));
        tCoupons.addAll(tCoupons1);
        //将返回结果会写到缓存里面
        couponIdsCache.putAll(tCouponMap);
        return tCoupons;
    }

    private List<TCoupon> couponByIds(List<Integer> ids) {
        TCouponExample example = new TCouponExample();
        example.createCriteria().andIdIn(ids);
        return tCouponMapper.selectByExample(example);
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

    @Override
    public void updateCoupon() {
        Map updateMap = new ConcurrentHashMap();
        List<TCoupon> tCoupons = this.loadCoupon(1);
        updateMap.put(1, tCoupons);
        couponMap = updateMap;
    }


}
