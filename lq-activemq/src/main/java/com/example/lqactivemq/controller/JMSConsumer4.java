package com.example.lqactivemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JMSConsumer4 {
    private Logger logger = LoggerFactory.getLogger(JMSConsumer4.class);
    @JmsListener(destination = "active.queue")
    public void reveiveMsg1(String msg) {
        logger.info("消费者1queue模式下收到的消息"+msg);
    }
    @JmsListener(destination = "active.topic",containerFactory = "jmsListenerContainerTopic")
    public void reveiveMsg2(String msg) {
        logger.info("消费者2topic模式下收到的消息"+msg);
    }
    @JmsListener(destination = "active.topic",containerFactory = "jmsListenerContainerTopic")
    public void reveiveMsg3(String msg) {
        logger.info("消费者3topic模式下收到的消息"+msg);
    }
}
