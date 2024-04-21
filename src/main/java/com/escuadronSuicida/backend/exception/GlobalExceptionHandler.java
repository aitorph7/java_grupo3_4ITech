package com.escuadronSuicida.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileException.class)
    public ResponseEntity<String> handleFileException(FileException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage()); // Error 400
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage()); // Error 404
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage()); // Error 403
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage()); // Error 401
    }
    @ExceptionHandler(ConflictDeleteException.class)
    public ResponseEntity<String> handleConflictDeleteException(ConflictDeleteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage()); // Error 409
    }
}
