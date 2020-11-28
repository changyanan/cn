package com.example.eurekaclientuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author changyanan1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaClientUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientUserServiceApplication.class, args);
	}
	@Bean
	public InMemoryHttpTraceRepository getInMemoryHttpTrace() {
		return new InMemoryHttpTraceRepository();
	}
}
