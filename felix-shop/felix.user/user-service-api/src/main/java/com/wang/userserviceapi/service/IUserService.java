package com.wang.userserviceapi.service;

import com.wang.userserviceapi.vo.UserVO;

/**
 * @Author：wp
 * @Package：com.wang.userserviceapi.service
 * @Project：java-Core
 * @name：IUserService
 * @Date：2023/4/25 15:22
 * @Filename：IUserService
 */
public interface IUserService {

    UserVO getByUserId(int id);
}
