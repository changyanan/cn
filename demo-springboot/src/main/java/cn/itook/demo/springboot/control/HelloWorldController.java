package cn.itook.demo.springboot.control;

import cn.itook.demo.springboot.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyanan1
 */
@RestController
public class HelloWorldController {

    private Environment environment;

    private MyConfig myConfig;

    @GetMapping("/hello")
    public String hello() {
        String port = environment.getProperty("server.port");
        String name = myConfig.getName();
        return name + "," + port;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Autowired
    public void setMyConfig(MyConfig myConfig) {
        this.myConfig = myConfig;
    }
}
