//package com.wang.couponapp.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisConnectionUtils;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import javax.annotation.Resource;
//
///**
// * @Author：wp
// * @Package：com.wang.couponapp.config
// * @Project：java-Core
// * @name：JedisPoolFactory
// * @Date：2023/4/26 10:18
// * @Filename：JedisPoolFactory
// */
//@Configuration
//public class JedisPoolFactory2 {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Resource
//    private RedisTemplate redisTemplate;
//
//    /**
//     * 初始化Redis连接池
//     */
//    @Bean
//    public Jedis generateJedisPoolFactory() {
////        JedisPoolConfig poolConfig = new JedisPoolConfig();
////        poolConfig.setMaxTotal(maxActive);
////        poolConfig.setMaxIdle(maxIdle);
////        poolConfig.setMinIdle(minIdle);
////        poolConfig.setMaxWaitMillis(maxWaitMillis);
////        // 连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
////        poolConfig.setBlockWhenExhausted(Boolean.TRUE);
////        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout);
//        // 若设置了Redis密码，请调用如下构造函数
////        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
//        RedisConnection connection = RedisConnectionUtils.getConnection(redisTemplate.getConnectionFactory());
//        Jedis jedis  = (Jedis) connection.getNativeConnection();
//        return jedis;
//    }
//}
