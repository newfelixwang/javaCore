//package com.wang.couponapp.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;
//import org.redisson.config.TransportMode;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author：wp
// * @Package：com.wang.couponapp.config
// * @Project：java-Core
// * @name：RedissonClientConfig
// * @Date：2023/4/26 10:54
// * @Filename：RedissonClientConfig
// */
//@Configuration
//public class RedissonClientConfig {
//
//
//    @Bean
//    public RedissonClient redissonClient(){
//        Config config = new Config();
//        config.setTransportMode(TransportMode.NIO);
//        SingleServerConfig singleServerConfig = config.useSingleServer();
//        //可以用"rediss://"来启用SSL连接
//        singleServerConfig.setAddress("redis://127.0.0.1:6379");
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }
//}
