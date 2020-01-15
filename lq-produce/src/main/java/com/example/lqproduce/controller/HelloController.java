package com.example.lqproduce.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());
    @RequestMapping("/hello")
    public String hello(){
        return "produce服务已经注册到注册中心了";
    }

}
