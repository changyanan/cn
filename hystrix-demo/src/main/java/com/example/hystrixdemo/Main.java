package com.example.hystrixdemo;

import com.example.hystrixdemo.command.MyHystrixCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Future<String> zhangsan = new MyHystrixCommand("zhangsan").queue();
//        System.out.println(zhangsan.get());
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand("张三").execute();
        System.out.println(result);
        Future<String> future = new MyHystrixCommand("zhangsan").queue();
        System.out.println(future.get());
        context.shutdown();
    }
}
