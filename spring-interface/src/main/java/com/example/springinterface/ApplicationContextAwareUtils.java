package com.example.springinterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author changyanan1
 */

public class ApplicationContextAwareUtils implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
