package com.wang.userserviceapi.service;

import com.wang.userserviceapi.vo.UserVO;

/**
 * @author wp
 * @ClassName IUserService
 * @description: TODO
 * @datetime 2023年 03月 30日 7:08
 * @version: 1.0
 */

public interface IUserService {

    UserVO getByUserId(int id);
}
