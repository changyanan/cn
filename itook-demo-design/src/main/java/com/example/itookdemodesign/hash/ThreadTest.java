package com.example.itookdemodesign.hash;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        ExecutorService executorService2 = Executors.newFixedThreadPool(30);
//        ExecutorService executorService3 = Executors.newScheduledThreadPool(30);
//        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
        int a = 2;
        int b = 31;
        System.out.println(a & 1);
        System.out.println(b & 1);

        int x = 8;
        int y = 9;
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println(x + "," + y);
    }
}
