package com.example.kanbam.service;

import com.example.kanbam.Constants.Constants;
import com.example.kanbam.pojo.Task;
import com.example.kanbam.repository.KanbamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
