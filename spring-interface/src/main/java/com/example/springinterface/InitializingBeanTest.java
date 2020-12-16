package com.example.springinterface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

/**
 * @author changyanan1
 */
@Service
public class InitializingBeanTest implements InitializingBean, DisposableBean, SmartInitializingSingleton {
    @Override
    public void destroy() {
        System.err.println("destroy...");
    }

    @Override
    public void afterPropertiesSet() {
        System.err.println("afterPropertiesSet...");
    }

    @Override
    public void afterSingletonsInstantiated() {

    }
}
