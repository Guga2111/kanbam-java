package com.example.kanbam.service;

import com.example.kanbam.Constants.Constants;
import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Task;
import com.example.kanbam.repository.KanbamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KanbamService {

    @Autowired
    KanbamRepository kanbamRepository;

    public void addTask(Task task) {
        kanbamRepository.addTask(task);
    }

    public void deleteTask(Task task) {
        kanbamRepository.deleteTask(task);
    }

    public void updateTask(Task task, int index) {
        kanbamRepository.updateTask(task, index);
    }

    public Task getTask(int index) {
        return kanbamRepository.getTask(index);
    }

    public List<Task> getTasks() {
        return kanbamRepository.getTasks();
    }

    public List<Task> getToDo() {
        return kanbamRepository.getToDo();
    }

    public List<Task> getDoing() {
        return kanbamRepository.getDoing();
    }

    public List<Task> getDone() {
        return kanbamRepository.getDone();
    }

    public void addToDoTask(Task task) {
        kanbamRepository.addToDoTask(task);
    }

    public void addDoingTask(Task task) {
        kanbamRepository.addDoingTask(task);
    }

    public void addDoneTask(Task task) {
        kanbamRepository.addDoneTask(task);
    }

    public int getIndexFromId(String id) {
        for(int i = 0; i < getTasks().size(); i++) {
            Task task = getTask(i);
            if(task.getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Task getTaskById(String id) {
        int index = getIndexFromId(id);
        return index == Constants.NOT_FOUND ? new Task() : getTask(index);
    }

    public void submitTask(Task task) {

        addTask(task);
    }

    public void spreadingTasks(List<Task> taskList) {

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
        return kanbamRepository.createTaskCollection();
    }
}
