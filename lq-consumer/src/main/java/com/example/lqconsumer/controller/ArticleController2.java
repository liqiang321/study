package com.example.lqconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController2 {
    @Autowired
    private RestTemplate restTemplate;

    /*url设置成服务名可以再负载的时候使用*/
    @GetMapping("/article/callHello2")
    public String callHello() {
        return restTemplate.getForObject("http://lq-produce/hello/user",String.class);
    }

}
