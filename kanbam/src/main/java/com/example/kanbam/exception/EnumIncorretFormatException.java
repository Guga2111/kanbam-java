package com.example.kanbam.exception;

import java.util.Optional;

public class EnumIncorretFormatException extends RuntimeException{
    public EnumIncorretFormatException(String value) {
        super("the format of the enum is incorrect: " + value);
    }
    //for empty requests
    public EnumIncorretFormatException() {
        super("The enum is null ( empty )");
    }
}
