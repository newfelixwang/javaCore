package com.wang.userserviceapi.vo;

import java.util.Date;

/**
 * @Author：wp
 * @Package：com.wang.userserviceapi.vo
 * @Project：java-Core
 * @name：UserVO
 * @Date：2023/4/25 15:23
 * @Filename：UserVO
 */
public class UserVO {

    private Integer id;

    private String userCouponCode;

    private String picUrl;

    private Integer couponId;

    private Integer userId;

    private Integer status;

    private Integer orderId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCouponCode() {
        return userCouponCode;
    }

    public void setUserCouponCode(String userCouponCode) {
        this.userCouponCode = userCouponCode;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userCouponCode=").append(userCouponCode);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", couponId=").append(couponId);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", orderId=").append(orderId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

}
