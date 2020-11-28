package com.example.springresttemplate.api.client;

import org.springframework.stereotype.Component;

/**
 * @author changyanan1
 */
@Component
public class UserRemoteClientFallback implements UserRemoteClient {
    @Override
    public String getData(String name) {
        return "失败！";
    }
}
