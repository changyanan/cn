package com.example.itookdemodesign.tree;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author changyanan1
 */
public class ThreadLocalOutOfMemoryTest {
    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(6, 6, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 500; ++i) {
            poolExecutor.execute(() -> {
                // (4)
                localVariable.set(new LocalVariable());
                // (5)
                System.out.println("use local varaible");
//                localVariable.remove();
            });
            Thread.sleep(1000);
        }
        // (6)
        System.out.println("pool execute over");
    }
}
