package com.example.dubboprovider;

import java.util.concurrent.*;

public class ThreadToolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ThreadToolTest threadPoolTest = new ThreadToolTest();
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                while (true) {
                    Future<String> future = threadPoolTest.submit();
                    try {
                        String s = future.get();
                        System.out.println(s);
//                        threadPoolTest.toString();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        threadPoolTest.toString();
        //子线程不停gc，模拟偶发的gc
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.gc();
                }
            }
        }).start();

//        for (int i = 0; i < 8; i++) {
//
//                new Thread(() -> {
//                    while (true){
//                        Future<String> future = threadPoolTest.submit();
//                    try {
//                        System.out.println(future.get());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                    }
//                }).start();
//
//
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.gc();
//                }
//            }
//        }).start();

    }

    /**
     * 异步执行任务
     *
     * @return
     */
    public Future<String> submit() {
        //关键点，通过Executors.newSingleThreadExecutor创建一个单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(50);
                return "hello world!";
            }
        });
        executorService.execute(futureTask);
        executorService.toString();
        return futureTask;
    }
}
