package com.example.dubboconsumer.control;

import com.example.dubboapi.model.User;
import com.example.dubboapi.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author changyanan1
 */
@Controller
public class OrderController {
    @Reference  //注入要调用的服务
    private UserService userService;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        //调用服务
        User user = userService.findUserById(id);
        return user;
    }
}
