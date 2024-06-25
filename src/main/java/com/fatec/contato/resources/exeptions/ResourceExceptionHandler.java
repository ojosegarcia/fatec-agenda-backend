package com.fatec.contato.resources.exeptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StanderdError>entityNotFoundException(EntityNotFoundException e, 
    HttpServletRequest request){

        StanderdError error = new StanderdError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource Not Found");    
        error.setMessage(e.getMessage());
        error.setTimeStamp(Instant.now());
        error.setPath(request.getRequestURI());


        return ResponseEntity.status(HttpStatus. NOT_FOUND).body(error);
    }
}
