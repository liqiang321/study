package com.example.lqproducer1.controller;

import com.example.lqproducer1.Entity.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Value("${name:aaa}")
    private String name;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello/hello1", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instances = client.getInstances("producer-service");
        for (int i = 0; i < instances.size(); i++) {
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
            System.out.println("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "Hello World";
    }
    //测试配置中心
    @RequestMapping(value = "/test/config", method = RequestMethod.GET)
    public String testConfig() {
        return name;
    }


    @Value("${logging.path:111}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
