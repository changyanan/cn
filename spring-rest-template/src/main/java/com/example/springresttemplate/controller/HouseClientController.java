package com.example.springresttemplate.controller;

import com.example.springresttemplate.api.client.UserRemoteClient;
import com.example.springresttemplate.model.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author changyanan1
 */
@RestController
public class HouseClientController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping(value = "/call/data", produces = {"application/json;charset=UTF-8"})
    public String getData(@RequestParam("name") String name) {
        return userRemoteClient.getData(name);
    }

    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }

    @GetMapping("/call/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:8085/house/data/{name}", String.class, name);
    }

    @GetMapping(value = "/choose", produces = {"application/json;charset=UTF-8"})
    public Object chooseUrl() {
        ServiceInstance instance = loadBalancer.choose("ribbon-eureka-demo");
        return instance;
    }
}
