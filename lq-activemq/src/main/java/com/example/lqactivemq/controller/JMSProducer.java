package com.example.lqactivemq.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class JMSProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    /*//生产者发送消息，测试原生的queue和topic
    @RequestMapping("queue")
    public  void sendMessage2(String msg) {
        for (int i = 0 ;i <10;i++) {
            this.jmsTemplate.convertAndSend(queue, "我是生产者发送的Queue消息");
        }
    }
    @RequestMapping("/topic")
    public void sendMessage3(String msg) {
        for (int i = 0 ;i <10;i++) {
            this.jmsTemplate.convertAndSend(topic, "我是生产者发送的Topic消息");
        }
    }*/









}
