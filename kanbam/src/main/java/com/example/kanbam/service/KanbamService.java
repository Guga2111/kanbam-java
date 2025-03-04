package com.example.kanbam.service;


import com.example.kanbam.exception.TaskNotFoundException;
import com.example.kanbam.pojo.Priority;
import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Task;
import com.example.kanbam.repository.KanbamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class KanbamService {

    KanbamRepository kanbamRepository;

    public List<Task> getTasks() {
        return (List<Task>) kanbamRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> task = kanbamRepository.findById(id);
        return unwrapTask(task, id);
    }

    //resolver bug nessa funcao
    public Task saveTask(Task task, String priority) {
        Optional<Task> taskOptional = kanbamRepository.findById(task.getId());
        Task taskUnwrapped = unwrapTask(taskOptional, task.getId());
        taskUnwrapped.setPriority(Priority.valueOf(priority));
        return kanbamRepository.save(taskUnwrapped);
    }

    public void deleteTask(Long id) {
        kanbamRepository.deleteById(id);
    }

    public Task updateTask(String status, String priority, Long id) {
        Optional<Task> task = kanbamRepository.findById(id);
        Task unwrappedTask = unwrapTask(task, id);
        unwrappedTask.setStatus(Status.valueOf(status));
        unwrappedTask.setPriority(Priority.valueOf(priority));
        return kanbamRepository.save(unwrappedTask);
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new TaskNotFoundException(id);
    }
}
