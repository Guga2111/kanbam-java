package com.example.kanbam.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("The task id '"+ id +"' not found");
    }
}
