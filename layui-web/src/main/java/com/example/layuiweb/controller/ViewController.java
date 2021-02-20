package com.example.layuiweb.controller;

import com.example.layuiweb.common.FebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author changyanan1
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String login() {
        return FebUtil.view("login-1");
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("welcome")
    public String welcome() {
        return FebUtil.view("welcome-1");
    }

    @GetMapping("login-1")
    public String login1() {
        return FebUtil.view("login-1");
    }

    @GetMapping("login-2")
    public String login2() {
        return FebUtil.view("login-2");
    }

    @GetMapping("login-3")
    public String login3() {
        return FebUtil.view("login-3");
    }
}
