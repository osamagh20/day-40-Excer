package com.example.day39exer.ControllerAdvice;

import com.example.day39exer.ApiResponse.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity ApiException(ApiException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity IndexOutOfBoundsException(IndexOutOfBoundsException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }



    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity MissingServletRequestParameterException(MissingServletRequestParameterException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }



    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity HttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity JpaSystemException(JpaSystemException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
    public ResponseEntity ObjectOptimisticLockingFailureException(ObjectOptimisticLockingFailureException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity HttpMessageNotWritableException(HttpMessageNotWritableException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
