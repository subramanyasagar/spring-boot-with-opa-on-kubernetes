package com.springboot.opa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class CommonExceptionHandlers  {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> handleParseException(HttpClientErrorException ex) {
        // Customize the response entity
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized to view the endpoint");
    }

}