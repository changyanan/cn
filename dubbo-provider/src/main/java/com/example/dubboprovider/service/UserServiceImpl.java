package com.example.dubboprovider.service;

import com.example.dubboapi.model.User;
import com.example.dubboapi.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author changyanan1
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("王几把想");
        user.setPassword("********");
        user.setTel("8888888888");
        user.setAddress("北京天安门");
        return user;
    }
}
