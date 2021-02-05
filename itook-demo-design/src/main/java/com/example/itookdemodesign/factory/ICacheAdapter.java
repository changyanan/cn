package com.example.itookdemodesign.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author changyanan1
 */
public interface ICacheAdapter {
    /**
     * 取
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 添加
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 添加实效
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit);

    /**
     * 删除
     *
     * @param key
     */
    void delete(String key);
}
