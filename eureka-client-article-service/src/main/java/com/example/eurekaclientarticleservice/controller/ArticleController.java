package com.example.eurekaclientarticleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author changyanan1
 */
@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }
}
