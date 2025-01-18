package com.example.kanbam.repository;

import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KanbamRepository {
    //crud
    private List<Task> taskList = new ArrayList<>();
    private List<Task> toDo = new ArrayList<>();
    private List<Task> doing = new ArrayList<>();
    private List<Task> done = new ArrayList<>();

    //read
    public Task getTask(int index) {
        return taskList.get(index);
    }

    //read
    public List<Task> getTasks() {
        return taskList;
    }

    //create
    public void addTask(Task task) {
        taskList.add(task);
    }

    //delete
    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    //update
    public void updateTask(Task task, int index) {
        taskList.set(index, task);
    }

    public void addToDoTask(Task task) {
        toDo.add(task);
    }

    public List<Task> getToDo() {
        return toDo;
    }

    public void addDoingTask(Task task) {
        doing.add(task);
    }

    public List<Task> getDoing() {
        return doing;
    }

    public void addDoneTask(Task task) {
        done.add(task);
    }

    public List<Task> getDone() {
        return done;
    }

    public void spreadingTasks() {

        if (taskList == null || taskList.isEmpty()) {
            throw new IllegalArgumentException("The task list cannot be empty or null");
        }

        for(Task task : taskList) {
            Status status = task.getStatus();

            if (status == null) {
                throw new IllegalArgumentException("Status invalid");
            }

            switch (status){
                case TODO -> addToDoTask(task);
                case IN_PROGRESS -> addDoingTask(task);
                case DONE -> addDoneTask(task);
                default -> throw new IllegalStateException("Unknown status: " + status);
            }
        }
    }

    public Map<String, List<Task>> createTaskCollection() {
        Map<String, List<Task>> taskCollections = new HashMap<>();

        taskCollections.put("toDo", toDo);
        taskCollections.put("doing", doing);
        taskCollections.put("done", done);
        return taskCollections;
    }
}
