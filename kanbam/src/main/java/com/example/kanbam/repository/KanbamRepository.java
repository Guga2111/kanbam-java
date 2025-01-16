package com.example.kanbam.repository;

import com.example.kanbam.pojo.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KanbamRepository {
    //crud
    private List<Task> taskList = new ArrayList<>();

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
}
