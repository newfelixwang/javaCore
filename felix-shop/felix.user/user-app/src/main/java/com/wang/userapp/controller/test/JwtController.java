package com.wang.userapp.controller.test;

import com.wang.userapp.entity.User;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
                .setPayload("222")
                .setClaims(map).compact();
        return token;
    }

    public static void main(String[] args) {

        String singKey = "test";

        Map map = new HashMap<>();
        map.put("a","b");
        //设置入参
        JwtBuilder jwtBuilder = Jwts.builder();
        String token = jwtBuilder.setSubject("22")
                .setIssuedAt(new Date())
               // .setPayload("aaa")
                .signWith(SignatureAlgorithm.HS256,singKey)
                .setClaims(map).compact();

        System.out.println(token);

//        Integer a1 = new Integer(127);
//        Integer a2 = new Integer(127);
//
//        Integer b1 = new Integer(128);
//        Integer b2 = new Integer(128);
//        System.out.println(a1 == a2);
//        System.out.println(b1 == b2);
//
//        Integer a1 = new Integer(127);
//        Integer a2 = new Integer(127);

//        Integer a =new Integer(3);
//        Integer b =3;
//        int c =3;
//        System.out.println(a == b);
//        System.out.println(a == c);


        Integer a =new Integer(129);
        Integer b = 129;
        int c =  129;
        System.out.println(a == b);
        System.out.println(a == c);
    }

}
