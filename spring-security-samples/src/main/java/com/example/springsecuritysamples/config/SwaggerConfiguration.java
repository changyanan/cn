package com.example.springsecuritysamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("test");
    }
}
