package com.example.kanbam.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("the id '" + id + "' was not found in our records!");
    }
}
