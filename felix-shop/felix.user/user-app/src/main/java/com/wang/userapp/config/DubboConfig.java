package com.wang.userapp.config;

import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.config
 * @Project：java-Core
 * @name：DoubbConfig
 * @Date：2023/4/13 12:29
 * @Filename：DoubbConfig
 */

@Configuration
public class DubboConfig {


    /**
     * 新增zookeeper 注册地址
     * @return
     */
    @Bean
    public MetadataReportConfig MetaDataReportConfig(){
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://127.0.0.1:2181");
        return metadataReportConfig;
    }
}
