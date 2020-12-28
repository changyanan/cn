package com.example.shardingexample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        AtomicInteger sum = new AtomicInteger();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                    System.err.println("test");
                    sum.addAndGet(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(sum);
    }
}
