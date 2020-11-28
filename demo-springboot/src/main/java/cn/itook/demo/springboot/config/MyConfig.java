package cn.itook.demo.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author changyanan1
 */
@ConfigurationProperties(prefix = "cn.itook")
@Component
public class MyConfig {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
