package com.example.aspectlogspringbootstarterdemo.control;

import cn.itook.autoconfiguration.aspectlog.annotation.AspectLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    @AspectLog
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
