package com.backend.tinkoff_backend.exceptions;

public class MyRetrievalFailureException extends RuntimeException {
    public MyRetrievalFailureException(String message) {
        super(message);
    }
}
