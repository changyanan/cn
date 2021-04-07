package com.example.itookdemodesign.hash;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author changyanan1
 */
public class Foo {
    private String msg;


    public Foo(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void outInfo() {
        System.out.println("这是测试Java反射的测试类");
    }

    public void outInfo(String name) {
        System.out.println("这是测试Java反射的测试类:" + name);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class c = Class.forName("com.example.itookdemodesign.hash.Foo");
        Method outInfo = c.getMethod("outInfo", String.class);
        Constructor<Foo> cc = c.getConstructor(String.class);
        Foo oj = cc.newInstance("hello");
        outInfo.invoke(oj, "hello");
    }
}
