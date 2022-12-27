package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = APIRequestException.class)
    public ResponseEntity<Object> handleAPIRequestException(
            APIRequestException e
    ){
        APIException apiException=new APIException(e.getMessage(),e,HttpStatus.BAD_GATEWAY, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleAPIRequestException(
            NotFoundException e
    ){
        APIException apiException=new APIException(e.getMessage(),e,HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
