package com.example.springresttemplate.configuration;

import com.example.springresttemplate.annotation.MyLoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author changyanan1
 */
@Configuration
public class BeanConfiguration {
    /**
     * @return
     * @MyLoadBalanced
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
