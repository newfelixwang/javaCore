package com.wang.userapp.controller;

import com.wang.userapp.domain.TUserCoupon;
import com.wang.userapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wp
 * @ClassName UserController
 * @description: TODO
 * @datetime 2023年 03月 30日 6:40
 * @version: 1.0
 */
@RestController
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping("/getById")
    public TUserCoupon getById(@RequestParam Integer id) {
        return userService.getuserById(id);
    }
}
