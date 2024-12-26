package org.example;

import lombok.*;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    /*
    Return Map where:
    Key is Developer Name;
    Value is List of Tasks Title assigned to Developer
    */
    public static Map<String, List<String>> report (
            List<Task> tasks,
            List<Developer> developers,
            List<Assignment> assignments
    ) {

        Map<Integer, String> devMap = developers.stream().collect(Collectors.toMap(Developer::getId, Developer::getName));
        Map<Integer, String> taskMap = tasks.stream().collect(Collectors.toMap(Task::getId, Task::getTitle));

        Map<String, List<String>> devTasks = new HashMap<>(developers.size());

        for (Assignment assignment : assignments) {
            String name = devMap.get(assignment.getDeveloperId());
            List<String> taskList = devTasks.get(name);
            if (taskList != null) {
                taskList.add(taskMap.get(assignment.getTaskId()));
                continue;
            }

            List<String> devTaskList = new ArrayList<>();
            devTaskList.add(taskMap.get(assignment.getTaskId()));
            devTasks.put(name, devTaskList);
        }


        Task task = new DelTask();

        return devTasks;
    }

    public static class DelTask extends Task {

        public DelTask() {
            super(1, "title");
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Task {
        int id;
        String title;


    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Developer {
        private int id;
        private String name;

        public Integer getId() {
            return id;
        }
    }

    @Value
    public static class Assignment {
        int taskId;
        int developerId;
    }
}