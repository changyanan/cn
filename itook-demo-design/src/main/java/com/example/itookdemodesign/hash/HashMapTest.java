package com.example.itookdemodesign.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changyanan1
 */
public class HashMapTest {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        HashMapThread thread0 = new HashMapThread(map,ai);
        HashMapThread thread1 = new HashMapThread(map,ai);
        HashMapThread thread2 = new HashMapThread(map,ai);
        HashMapThread thread3 = new HashMapThread(map,ai);
        HashMapThread thread4 = new HashMapThread(map,ai);
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        thread4.start();
    }

}

class HashMapThread extends Thread {
    private AtomicInteger ai;
    private Map<Integer, Integer> map;
    public HashMapThread(Map<Integer, Integer> map,AtomicInteger ai) {
        this.ai = ai;
        this.map = map;
    }

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
            System.out.println(map.toString());
        }
    }
}