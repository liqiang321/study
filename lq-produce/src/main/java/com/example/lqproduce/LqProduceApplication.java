package com.example.lqproduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LqProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LqProduceApplication.class, args);
	}

}
