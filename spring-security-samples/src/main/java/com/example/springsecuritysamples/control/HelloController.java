package com.example.springsecuritysamples.control;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "商品信息管理接口")
public class HelloController {
    @Operation(summary = "商品详情,针对得到单个商品的信息")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
