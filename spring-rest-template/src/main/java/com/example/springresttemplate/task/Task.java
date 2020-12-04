package com.example.springresttemplate.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author changyanan1
 */
public interface Task {

    /**
     * 任务执行
     */
    void execute();
}
