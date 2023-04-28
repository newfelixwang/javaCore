package com.wang.orderapp.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author：wp
 * @Package：com.wang.orderapp.service
 * @Project：java-Core
 * @name：OrderService
 * @Date：2023/4/27 20:14
 * @Filename：OrderService
 */
@Service
public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Resource
    private DefaultMQProducer producer;


    public void sendMSG() {
        Date date = new Date();
        Object o1 = JSONObject.toJSON(date);
        Message message1 = new Message("payResult", "Tag1", "12345", o1.toString().getBytes());
        try {
            producer.send(message1, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    logger.info("MQ发送成功[{}]",sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    //TODO 发送MQ异常处理
                    logger.error("MQ发送失败[{}]",JSONObject.toJSONString(throwable.toString()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        long l = System.currentTimeMillis();
        Message message2 = new Message("saveOrder", "Tag1", "12345", String.valueOf(l).getBytes());
        try {
            producer.send(message2, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    logger.info("MQ发送成功[{}]",sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    //TODO 发送MQ异常处理
                    logger.error("MQ发送失败[{}]",JSONObject.toJSONString(throwable.toString()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
