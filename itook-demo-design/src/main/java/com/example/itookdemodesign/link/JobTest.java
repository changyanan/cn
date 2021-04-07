package com.example.itookdemodesign.link;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author changyanan1
 */
public class JobTest implements Runnable {
    private int status = 0;

    public JobTest(int status) {
        this.status = status;
    }

    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {
        if (status == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(1);
                }
            }
            return;
        }
        synchronized (o1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println(2);
            }
        }
        ApplicationContext context = new ClassPathXmlApplicationContext();
        context.getBean("");
    }

    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        JobTest jobTest = new JobTest();
//        new Thread(() -> jobTest.job1(lock)).start();
//        new Thread(() -> jobTest.job1(lock)).start();
        JobTest job1 = new JobTest(0);
        JobTest job2 = new JobTest(1);
        new Thread(job1).start();
        new Thread(job2).start();
    }

    //    @Test
    public void job1(Lock lock) {

        lock.lock();
//        Condition condition = lock.newCondition();
        try {
            System.out.println(Math.max(20, 30));
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    @Test
    public void job2() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

    }


}
