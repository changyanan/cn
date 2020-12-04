package com.example.springresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author changyanan1
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.springresttemplate.api.client")
@EnableHystrix
@SpringBootApplication
@EnableScheduling
public class SpringRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTemplateApplication.class, args);
    }

}
