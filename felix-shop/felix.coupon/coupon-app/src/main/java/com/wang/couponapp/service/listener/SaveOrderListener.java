package com.wang.couponapp.service.listener;

import com.wang.couponapp.config.OrderConsumerConfig;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author：wp
 * @Package：com.wang.couponapp.service.listener
 * @Project：java-Core
 * @name：SaveOrderListener
 * @Date：2023/4/27 20:40
 * @Filename：SaveOrderListener
 */

@Service
public class SaveOrderListener extends OrderConsumerConfig implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(SaveOrderListener.class);

    @Override
    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
        msgs.forEach(msg -> {
            byte[] bytes = msg.getBody();
            try {
                String msgStr = new String(bytes, "utf-8");
                log.info("save order receive msg:{}",msgStr);
            } catch (UnsupportedEncodingException e) {
                log.error("body转字符串失败");
            }
        });
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
