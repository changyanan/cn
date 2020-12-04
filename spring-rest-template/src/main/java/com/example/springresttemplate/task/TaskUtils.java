package com.example.springresttemplate.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changyanan1
 */
@Component
public class TaskUtils {

    private List<TaskModel> taskModels = new ArrayList<>();

    {
        taskModels.add(new TaskModel(new AddPerson()));

    }

    @Scheduled(cron = "*/5 * * * * ?")
    void execute() {
        taskModels.forEach(taskModel -> {
            execute(taskModel);
        });
    }

    void execute(TaskModel taskModel) {
        taskModel.getTask().execute();
    }


}
