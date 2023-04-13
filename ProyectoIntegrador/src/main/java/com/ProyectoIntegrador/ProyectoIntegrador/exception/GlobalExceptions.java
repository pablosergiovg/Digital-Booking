package com.ProyectoIntegrador.ProyectoIntegrador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions   {
    @ExceptionHandler({ ResourceNotFoundException.class })
    public ResponseEntity<String> procesarResourceNorFoundException (ResourceNotFoundException rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rnfe.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<String> procesaBadRequestException (BadRequestException bre){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bre.getMessage());
    }
}
