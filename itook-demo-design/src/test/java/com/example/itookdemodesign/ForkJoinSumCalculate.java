package com.example.itookdemodesign;

import java.util.concurrent.ForkJoinTask;

public class ForkJoinSumCalculate extends ForkJoinTask<Long> {

    public ForkJoinSumCalculate(long l, long l1) {
    }

    @Override
    public Long getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Long value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
