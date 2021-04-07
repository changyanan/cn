package com.example.itookdemodesign.linkList;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changyanan1
 */
public class CountDownLatchTest {
    private static CountDownLatch downLatch = new CountDownLatch(20);
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 3600, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
    private static AtomicInteger integer = new AtomicInteger();

    @Test
    public void testCountDownLatch() {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("Thread:" + finalI);
                integer.addAndGet(1);
                downLatch.countDown();
            });
        }
        System.out.println("线程全部执行完成。。。");
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("主线程结束:" + integer.get());
    }
}
