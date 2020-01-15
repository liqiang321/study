package com.example.lqactivemq;

import com.example.lqactivemq.controller.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootTest
class LqActivemqApplicationTests {
	@Autowired
	private JMSProducer jmsProducer;

	@Autowired
	private Topic topic;
	@Autowired
	private Queue queue;

	@Test
	public void testJms2() {
		for (int i=0;i<10;i++) {
			jmsProducer.sendMessage(queue,"queue,world!" + i+"主题为"+queue);
			//jmsProducer.sendMessage(topic, "topic,world!" + i+"主题为"+topic);
		}
	}

	/*@Test
	public void contextLoads() {
		Destination destination = new ActiveMQQueue("springboot.queue.test");
		for (int i=0;i<10;i++) {
			jmsProducer.sendMessage(destination,"hello,world!" + i);
		}
	}*/



}
