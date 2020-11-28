package com.example.eurekaclientuserservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyanan1
 */
@RestController
public class UserController {
    @GetMapping("/user/hello")
    public String hello() {
        return "hello";
    }
}
