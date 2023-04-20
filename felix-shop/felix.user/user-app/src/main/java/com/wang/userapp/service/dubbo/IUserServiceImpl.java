package com.wang.userapp.service.dubbo;

import com.wang.userapp.domain.TUserCoupon;
import com.wang.userapp.mapper.TUserCouponMapper;
import com.wang.userserviceapi.service.IUserService;
import com.wang.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @Author：wp
 * @Package：com.wang.userapp.service.dubbo
 * @Project：java-Core
 * @name：IUserServiceImpl
 * @Date：2023/4/13 17:04
 * @Filename：IUserServiceImpl
 */
@Service
public class IUserServiceImpl implements IUserService {


    @Resource
    private TUserCouponMapper tUserCouponMapper;

    @Override
    public UserVO getByUserId(int id) {
        UserVO userVO = new UserVO();
        TUserCoupon tUserCoupon = tUserCouponMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(tUserCoupon, userVO);
        return userVO;
    }
}
