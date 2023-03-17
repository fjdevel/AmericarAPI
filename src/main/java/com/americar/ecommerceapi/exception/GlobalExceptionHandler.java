package com.americar.ecommerceapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        HttpStatus status = ex.getStatusCode();
        String responseBody = ex.getResponseBodyAsString();
        return new ResponseEntity<>(responseBody, status);
    }

    // Aquí se agregan manejadores para otras excepciones, si es necesario.
}