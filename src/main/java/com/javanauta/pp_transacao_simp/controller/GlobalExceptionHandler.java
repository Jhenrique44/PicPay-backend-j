package com.javanauta.pp_transacao_simp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javanauta.pp_transacao_simp.infrastructure.exceptions.BadRequestException;
import com.javanauta.pp_transacao_simp.infrastructure.exceptions.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handeIllegalArgumentException(IllegalArgumentException e) { 
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handeBadRequestException(BadRequestException e) { 
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);  
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
