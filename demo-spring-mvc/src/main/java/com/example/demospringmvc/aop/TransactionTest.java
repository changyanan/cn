package com.example.demospringmvc.aop;

import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author changyanan1
 */
public class TransactionTest {
    private TransactionTemplate transactionTemplate;
    public void test1(){
        transactionTemplate.execute(()->{

        });
    }
}
