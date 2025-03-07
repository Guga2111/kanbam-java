package com.example.kanbam.exception;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(Long id) {
        super("The task id '"+ id +"' not found");
    }
}
