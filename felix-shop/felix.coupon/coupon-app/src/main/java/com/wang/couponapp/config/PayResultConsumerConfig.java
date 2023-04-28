package com.wang.couponapp.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.config
 * @Project：java-Core
 * @name：PayResultConsumerConfig
 * @Date：2023/4/27 20:31
 * @Filename：PayResultConsumerConfig
 */

@Configuration
public abstract class PayResultConsumerConfig {

    private static final Logger log = LoggerFactory.getLogger(PayResultConsumerConfig.class);


    @Value("${rocketmq.consumer.pay.groupName}")
    private String groupName;


    @Value("${rocketmq.consumer.pay.namesrvAddr}")
    private String namesrvAddr;


    public void consumer(String topic, String tag) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe(topic, tag);
        //监听对应的topic和tag
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msg, ConsumeConcurrentlyContext context) {
                log.info("consumeMessage------------【{}】",msg);
                return PayResultConsumerConfig.this.dealBody(msg);
            }
        });

        consumer.start();
        log.info("rocketmq启动成功-----------------------");
    }

    public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);

}
