package com.wang.couponapp.controller;

import com.wang.couponapp.entity.User;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Jwt生成
 */
@RestController
public class JwtController {


    @RequestMapping("/getToken")
    public String getToken(){
        //User user = new User(1,"张三","123");
        String userJson =  "123";

        Map map = new HashMap<>();
        //设置入参
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder.setSubject("22")
                .setClaims(map).compact();
        return token;
    }

}
