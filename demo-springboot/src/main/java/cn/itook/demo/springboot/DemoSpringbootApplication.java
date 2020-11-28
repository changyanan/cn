package cn.itook.demo.springboot;

import cn.itook.demo.springboot.config.StartCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyanan1
 */
@SpringBootApplication
public class DemoSpringbootApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }
}
