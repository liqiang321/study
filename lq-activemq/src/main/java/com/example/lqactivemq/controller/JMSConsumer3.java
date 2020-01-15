package com.example.lqactivemq.controller;


import com.example.lqactivemq.config.JMSConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JMSConsumer3 {
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
        private final static Logger logger = LoggerFactory.getLogger(JMSConsumer3.class);

        @JmsListener(destination = JMSConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
        public void onTopicMessage(String msg) {
            logger.info(topic+"1111111111111接收到topic消息：{}",msg);
        }

        @JmsListener(destination = JMSConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
        public void onTopicMessage2(String msg) {
            logger.info(topic+"222222222222222接收到topic消息：{}",msg);
        }

        @JmsListener(destination = JMSConfig.QUEUE)
        public void onQueueMessage1(String msg) {
            logger.info(queue+"3333333333333333接收到queue消息：{}",msg);
        }
        @JmsListener(destination = JMSConfig.QUEUE)
        public void onQueueMessage2(String msg) {
            logger.info(queue+"444444444444444接收到queue消息：{}",msg);
        }
    }
