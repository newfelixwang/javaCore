package com.wang.couponserviceapi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author：wp
 * @Package：com.wang.couponserviceapi.dto
 * @Project：java-Core
 * @name：UserCouponDto
 * @Date：2023/4/25 10:06
 * @Filename：UserCouponDto
 */
@Data
public class UserCouponDto implements Serializable {

    private Integer couponId;

    private Integer userId;

    private Integer orderId;


}
