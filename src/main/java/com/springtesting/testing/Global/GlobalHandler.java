package com.springtesting.testing.Global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(NoElementFound.class)
    public ResponseEntity<Object> getExce(NoElementFound ne){
        return new ResponseEntity<>(ne.getMessage(), HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(IdAlreadyExist.class)
    public ResponseEntity<Object> getsave(IdAlreadyExist exist){
        return new ResponseEntity<>(exist.getMessage(), HttpStatus.FOUND);
    }
    @ExceptionHandler(InvalidAge.class)
    public ResponseEntity<String> getAge(InvalidAge ie){
        return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
