package com.example.dubboapi.service;

import com.example.dubboapi.model.User;

/**
 * @author changyanan1
 */
public interface UserService {
    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);
}
