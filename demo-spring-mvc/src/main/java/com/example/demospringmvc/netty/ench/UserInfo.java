package com.example.demospringmvc.netty.ench;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author changyanan1
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 713469232417266093L;
    private String username;
    private Integer userId;

    public UserInfo buildUsername(String username) {
        this.username = username;
        return this;
    }

    public UserInfo buildUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] codec() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.username.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.getUserId());
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
