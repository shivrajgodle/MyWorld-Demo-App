package com.kpit.myworld.candidate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchCandidateException.class)
    public ResponseEntity<Object> handleNoSuchCandidateException(NoSuchCandidateException noSuchCandidateException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noSuchCandidateException.getMessage());
    }

}
