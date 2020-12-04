package com.example.springresttemplate.task;

/**
 * @author changyanan1
 */
public class TaskModel {
    private Task task;

    public TaskModel(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
