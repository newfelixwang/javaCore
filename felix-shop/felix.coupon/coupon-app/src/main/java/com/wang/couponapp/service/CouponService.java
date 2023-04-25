package com.wang.couponapp.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.wang.couponapp.constant.Constant;
import com.wang.couponapp.domain.TCoupon;
import com.wang.couponapp.domain.TCouponExample;
import com.wang.couponapp.domain.TUserCoupon;
import com.wang.couponapp.mapper.TCouponMapper;
import com.wang.couponapp.mapper.TUserCouponMapper;
import com.wang.couponserviceapi.dto.TCouponDto;
import com.wang.couponserviceapi.dto.UserCouponDto;
import com.wang.couponserviceapi.service.ICouponService;
import com.wang.userserviceapi.service.IUserService;
import com.wang.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @name：CouponService
 * @Date：2023/3/15 17:41
 * @Filename：CouponService
 */
@Service
public class CouponService implements ICouponService {


    Logger logger = LoggerFactory.getLogger(CouponService.class);

    @Resource
    private TCouponMapper tCouponMapper;

    @Reference
    private IUserService userService;

    @Resource
    private TUserCouponMapper tUserCouponMapper;


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


    public void print() {

        System.out.println("###");
    }

    /**
     * 查询所有优惠券
     *
     * @return
     */

    @Override
    public List<TCouponDto> getCouponList() throws ExecutionException {
        couponCache.get(1);
        ConcurrentMap<Integer, List<TCoupon>> integerListConcurrentMap = couponCache.asMap();
        List<TCoupon> tCoupons = integerListConcurrentMap.get(1);
        List<TCouponDto> dtos = Lists.newArrayList();
        BeanUtil.copyProperties(tCoupons,dtos);
        return dtos;
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


    public List<TCoupon> loadCoupon(Integer integer) {
        TCouponExample example = new TCouponExample();
        TCouponExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Constant.USERFULL);
        criteria.andStartTimeLessThan(new Date());
        criteria.andEndTimeGreaterThan(new Date());
        List<TCoupon> tCoupons = tCouponMapper.selectByExample(example);
        return tCoupons;
    }


    public UserVO getByUserId(Integer id) {
        UserVO user = userService.getByUserId(id);
        return user;
    }


    public void updateCoupon() {
        Map updateMap = new ConcurrentHashMap();
        List<TCoupon> tCoupons = this.loadCoupon(1);
        logger.info("当前更新的数量[{}]");
        updateMap.put(1, tCoupons);
        couponMap = updateMap;
    }


    @Override
    public String saveUserCoupon(UserCouponDto dto) {
        Integer couponId = dto.getCouponId();
        if (ObjectUtil.isAllEmpty(dto.getUserId(), couponId)) {
            return "couponId或者userId不能为空";
        }
        TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(couponId);
        if (ObjectUtil.isNull(tCoupon)) {
            return "coupon为空";
        }

        TUserCoupon tUserCoupon = new TUserCoupon();
        BeanUtil.copyProperties(dto, tUserCoupon);
        tUserCoupon.setCouponId(couponId);
        tUserCoupon.setPicUrl(tCoupon.getPicUrl());
        tUserCoupon.setCreateTime(new Date());
        tUserCoupon.setUserId(dto.getUserId());
        tUserCoupon.setStatus(0);
        String coupon = String.valueOf(IdUtil.getSnowflake().nextId());
        tUserCoupon.setUserCouponCode(coupon);
        tUserCouponMapper.insert(tUserCoupon);
        return "领取成功";
    }

}
