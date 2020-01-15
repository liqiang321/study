package com.example.lqconsumer1.controller;


import com.example.lqconsumer1.Entity.Book;
import com.example.lqconsumer1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloController() {
        return restTemplate.getForEntity("http://PRODUCER-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "testHystric", method = RequestMethod.GET)
    public String testHystric() {
        return  helloService.hello();
    }

    /*使用getForEntity的方式实现 调用*/
    @RequestMapping("/gethello")
    public String getHello() {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://PRODUCER-SERVICE/hello", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }



    /*
     * 测试RestTemplate的put请求
     * */
    @RequestMapping("/book3")
    public Book book3() {
        Book book = new Book();
        book.setName("红楼梦");
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity("http://PRODUCER-SERVICE/getbook2", book, Book.class);
        return responseEntity.getBody();
    }

    /*测试get请求带参数*/
    @GetMapping("/getHello1")
    public Book getHello1(@RequestParam("name") String name) {
       return  restTemplate.getForObject("hhtp://localhost:1081/hello1?name=" + name, Book.class);
    }

    /*
     *   测试put请求
     * *//*

    @RequestMapping("/put")
    public void put() {
        Book book = new Book();
        book.setName("红楼梦");
        restTemplate.put("http://PRODUCER-SERVICE/getbook3/{1}", book, 99);
    }

    *//*
     *   测试delete请求
     * *//*
    @RequestMapping("/delete")
    public void delete() {
        restTemplate.delete("http://PRODUCER-SERVICE/getbook4/{1}", 100);
    }*/
}
