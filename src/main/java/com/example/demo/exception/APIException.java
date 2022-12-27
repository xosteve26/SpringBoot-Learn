package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class APIException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public APIException(String message, Throwable cause, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }

    @Override
    public String toString() {
        return "APIException{" +
                "message='" + message + '\'' +
                ", cause=" + cause +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }
}
