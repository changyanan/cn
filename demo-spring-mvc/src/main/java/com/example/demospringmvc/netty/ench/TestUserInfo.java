package com.example.demospringmvc.netty.ench;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author changyanan1
 */
public class TestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUsername("wangmingxiang");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(info);
        objectOutputStream.flush();
        objectOutputStream.close();
        byte[] b = byteArrayOutputStream.toByteArray();
        System.out.println("The jdk length:" + b.length);
        byteArrayOutputStream.close();
        System.out.println("================================");
        System.out.println("the byte :" + info.codec().length);
    }
}
