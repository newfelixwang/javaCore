package com.wang.orderapp.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：wp
 * @Package：com.wang.orderapp.config
 * @Project：java-Core
 * @name：ProducerConfigure
 * @Date：2023/4/27 20:07
 * @Filename：ProducerConfigure
 */
@Configuration
public class ProducerConfigure {

    private static final Logger log = LoggerFactory.getLogger(ProducerConfigure.class);

    @Value("${rocketmq.producer.groupName}")
    private String groupName;

    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;


    @Bean
    public DefaultMQProducer DefaultMQProducer() throws MQClientException {

        String[] topics = {"payResult", "saveOrder", "TopicC", "TopicD"};
        DefaultMQProducer producer = null;
        for (String topic : topics){
            producer = new DefaultMQProducer(topic);
            producer.setNamesrvAddr(namesrvAddr);
            producer.setRetryTimesWhenSendAsyncFailed(10);

            producer.start();
        }
        log.info("start rocketmq producer success!");
        return producer;
    }

    
}
