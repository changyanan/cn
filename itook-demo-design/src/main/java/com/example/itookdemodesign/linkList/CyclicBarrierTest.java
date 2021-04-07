package com.example.itookdemodesign.linkList;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author changyanan1
 */
public class CyclicBarrierTest {
    //    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("开始上班："));
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 3600, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());

    @Test
    public void cyclicBarrierTest() {

        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(i, barrier)).start();
        }
    }
}

class Worker implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int name;

    public Worker(int name, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            System.out.println("睁眼:" + name);
            cyclicBarrier.await();
//            Thread.sleep(1000);
//            System.out.println("刷牙:" + name);
//            cyclicBarrier.await();
//            Thread.sleep(1000);
//            System.out.println("洗脸:" + name);
//            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

//class TaskThread extends Thread {
//    CyclicBarrier barrier;
//
//    public TaskThread(CyclicBarrier barrier) {
//        this.barrier = barrier;
//    }
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(1000);
//            System.out.println(getName() + " 到达栅栏 A");
//            barrier.await();
//            System.out.println(getName() + " 冲破栅栏 A");
//
//            Thread.sleep(2000);
//            System.out.println(getName() + " 到达栅栏 B");
//            barrier.await();
//            System.out.println(getName() + " 冲破栅栏 B");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}