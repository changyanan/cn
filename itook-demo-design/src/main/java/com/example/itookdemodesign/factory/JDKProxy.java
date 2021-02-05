package com.example.itookdemodesign.factory;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author changyanan1
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) {
        InvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = interfaceClass.getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaces[0]},
                invocationHandler);
    }
}
