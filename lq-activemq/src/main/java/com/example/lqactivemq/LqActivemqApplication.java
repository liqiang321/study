package com.example.lqactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class LqActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LqActivemqApplication.class, args);
	}

}
