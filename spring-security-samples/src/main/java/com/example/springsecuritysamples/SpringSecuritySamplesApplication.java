package com.example.springsecuritysamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class SpringSecuritySamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySamplesApplication.class, args);
	}

}
