package com.example.demospringmvc.netty;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author changyanan1
 */
public class TimeServerHandlerExecutePool {
    private ExecutorService executorService;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}
