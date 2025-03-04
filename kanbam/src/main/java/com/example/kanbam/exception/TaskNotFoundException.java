package com.example.kanbam.exception;

import com.example.kanbam.pojo.Task;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("The task id '"+ id +"' not found");
    }
}
