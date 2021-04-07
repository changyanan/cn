package com.example.itookdemodesign.link;

/**
 * @author changyanan1
 */
public class HelloJob {
}

class
Thread1 implements Runnable {

    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}