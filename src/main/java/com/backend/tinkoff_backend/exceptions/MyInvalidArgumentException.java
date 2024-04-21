package com.backend.tinkoff_backend.exceptions;

public class MyInvalidArgumentException extends RuntimeException {
    public MyInvalidArgumentException(String message) {
        super(message);
    }
}
