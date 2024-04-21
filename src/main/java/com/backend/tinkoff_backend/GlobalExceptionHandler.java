package com.backend.tinkoff_backend;

import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyInvalidArgumentException.class)
    public ResponseEntity<String> myInvalidArgumentException(MyInvalidArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MyRetrievalFailureException.class)
    public ResponseEntity<String> myRetrievalFailureException(MyRetrievalFailureException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
