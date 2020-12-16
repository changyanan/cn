package com.example.dubboprovider;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteUpgardeDemo {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void upgarde() {
        System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到了读锁");
            System.out.println(Thread.currentThread().getName() + "阻塞获取写锁");
            writeLock.lock();

        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteUpgardeDemo reentrantReadWriteUpgardeDemo = new ReentrantReadWriteUpgardeDemo();
        new Thread(() -> reentrantReadWriteUpgardeDemo.upgarde(), "线程1").start();
        new Thread(() -> reentrantReadWriteUpgardeDemo.upgarde(), "线程2").start();
    }
}
