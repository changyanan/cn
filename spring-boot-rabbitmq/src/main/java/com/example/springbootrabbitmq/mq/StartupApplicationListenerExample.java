package com.example.springbootrabbitmq.mq;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author changyanan1
 */
@Component
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOG
            = Logger.getLogger(String.valueOf(StartupApplicationListenerExample.class));
    public static int counter;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOG.info("Increment counter");
        System.err.println("Increment counter");
        counter++;
    }
}
