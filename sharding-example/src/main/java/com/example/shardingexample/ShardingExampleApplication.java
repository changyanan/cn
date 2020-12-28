package com.example.shardingexample;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyanan1
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.shardingexample.mapper"})
@EnableEncryptableProperties
public class ShardingExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingExampleApplication.class, args);
    }

}
