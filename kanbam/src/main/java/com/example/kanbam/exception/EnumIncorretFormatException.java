package com.example.kanbam.exception;

public class EnumIncorretFormatException extends RuntimeException{
    public EnumIncorretFormatException() {
        super("the format of the enum is incorrect");
    }
}
