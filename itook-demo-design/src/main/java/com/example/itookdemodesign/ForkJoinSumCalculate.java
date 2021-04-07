package com.example.itookdemodesign;

import java.util.concurrent.RecursiveTask;

/**
 * @author changyanan1
 */
public class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;
    /**
     * 临界值
     */
    private static final long THURSHOLD = 10000L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        long middle = (start + end) / 2;
        ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
        left.fork();
        ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
        right.fork();
        return left.join() + right.join();
    }
}
