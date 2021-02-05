package com.example.itookdemodesign.factory.impl;

import com.example.itookdemodesign.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author changyanan1
 */
public class EGMCacheAdapter implements ICacheAdapter {
    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {

    }

    @Override
    public void delete(String key) {

    }
}
