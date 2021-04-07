package com.example.itookdemodesign.linkList;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changyanan1
 */
public class ExecutorsDemo {
    private static AtomicInteger ai = new AtomicInteger(1);
    private static ThreadFactory n = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ThreadPoolTaskExecutor pool;
    static {
        pool = new ThreadPoolTaskExecutor();
        pool.setMaxPoolSize(20);
        pool.setCorePoolSize(5);
        pool.setKeepAliveSeconds(3600);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        pool.setQueueCapacity(200);
        pool.initialize();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            Thread.sleep(50);
            pool.execute(() -> {
                ai.incrementAndGet();
//                try {
////                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("test" + ai.get());
            });

        }
        pool.shutdown();
    }
}
