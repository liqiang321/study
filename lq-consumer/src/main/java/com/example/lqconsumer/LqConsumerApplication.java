package com.example.lqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LqConsumerApplication.class, args);
	}

}
