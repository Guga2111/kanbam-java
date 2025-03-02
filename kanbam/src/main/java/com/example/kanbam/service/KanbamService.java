package com.example.kanbam.service;

import com.example.kanbam.Constants.Constants;
import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Task;
import com.example.kanbam.repository.KanbamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KanbamService {

    @Autowired
    KanbamRepository kanbamRepository;

    public List<Task> getTasks() {
        return (List<Task>) kanbamRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> task = kanbamRepository.findById(id);
        return task.get();
    }

    public Task saveTask(Task task) {
        return kanbamRepository.save(task);
    }

    public void deleteTask(Long id) {
        kanbamRepository.deleteById(id);
    }

    public Task updateTask(Status status, Long id) {
        Task task = getTask(id);

        return kanbamRepository.save(task);
    }
}
