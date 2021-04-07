package com.example.itookdemodesign.linkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author changyanan1
 */
public class ExecutorsDemo1 {
    TimeUnit unit;
    BlockingQueue workQueue;

    @Test
    public void testThread() {
        // 创建线程池
        ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(10, 10, 3600, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10000), (r, executor) -> {
            System.err.println("hello");
        });
        ExecutorService threadPool2 = Executors.newFixedThreadPool(4);
        // 执行任务
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int index = i;
            threadPool1.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
    }

    @Test
    public void testSemaphore() {
        final List<String> tableNames = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            tableNames.add("a");
            tableNames.add("b");
            tableNames.add("c");
            tableNames.add("d");
        }

        final Semaphore semaphore = new Semaphore(30);
        final ExecutorService fixedThread = Executors.newCachedThreadPool();
        for (final String tableName : tableNames) {
            //阻塞，获取令牌
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //do
            fixedThread.execute(() -> {
                final ExecutorService executorService = Executors.newCachedThreadPool();
                try {
                    executorService.submit(() -> { //can't throw ex log
                        //int i = 1/0;
                        System.out.println("tableName2:" + tableName);
                    });
                    //int i = 1/0;
                    System.out.println("tableName:" + tableName);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    executorService.shutdown();
                    try {
                        executorService.awaitTermination(1, TimeUnit.DAYS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    System.out.println("semaphore.release");
                }
            });
        }
        // 记得关闭线程池
        fixedThread.shutdown();
        try {
            fixedThread.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程...");
    }
}