package com.smithexperience.departmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){

        //custom response to the client when error occurs
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND");

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<CustomErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException exception, WebRequest webRequest){

        //custom response to the client when error occurs
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_EMAIL_ALREADY_EXISTS");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    //handling Global Exceptions; when a Specific Exception is not defined - a general Exception [that inherits from Java Exception class]
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){

        //custom response to the client when error occurs
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR");

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}