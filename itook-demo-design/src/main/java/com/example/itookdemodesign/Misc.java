package com.example.itookdemodesign;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author changyanan1
 */
public class Misc {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService es1 = Executors.newSingleThreadExecutor();
//        ExecutorService es2 = Executors.newFixedThreadPool();
//        ExecutorService es3 = Executors.newCachedThreadPool();
//        ExecutorService es4 = Executors.newScheduledThreadPool()
//        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 > o2 ? 0 : 1;
//            }
//        });
//        treeMap.put(1, 2);
//        treeMap.put(6, 1);
//        treeMap.put(2, 2);
//        treeMap.put(9, 1);
//        treeMap.put(3, 1);
//        System.out.println(treeMap);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        countDownLatch.countDown();



    }
}
