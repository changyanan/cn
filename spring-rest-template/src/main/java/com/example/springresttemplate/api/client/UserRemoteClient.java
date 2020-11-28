package com.example.springresttemplate.api.client;

import com.example.springresttemplate.configuration.FeignConfiguration;
import com.example.springresttemplate.model.HouseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author changyanan1
 */
@FeignClient(value = "ribbon-eureka-demo", configuration = FeignConfiguration.class)
public interface UserRemoteClient {
    /**
     * 测试
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/house/data", produces = {"application/json;charset=UTF-8"})
    String getData(@RequestParam("name") String name);

//    /**
//     * 测试
//     *
//     * @return
//     */
//    @GetMapping("/article/callHello")
//    String callHello();
}
