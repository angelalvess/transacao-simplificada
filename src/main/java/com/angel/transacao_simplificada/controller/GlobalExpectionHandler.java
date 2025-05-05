package com.angel.transacao_simplificada.controller;

import com.angel.transacao_simplificada.infrastructure.exceptions.BadRequestException;
import com.angel.transacao_simplificada.infrastructure.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpectionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return  new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e){
        return  new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e){
        return  new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
