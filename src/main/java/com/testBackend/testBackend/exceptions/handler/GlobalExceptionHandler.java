package com.testBackend.testBackend.exceptions.handler;

import com.testBackend.testBackend.exceptions.ErrorDatosException;
import com.testBackend.testBackend.exceptions.RequiredDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ErrorDatosException.class)
    ResponseEntity<MessageError> errorDataException(ErrorDatosException errorDatosException) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body((MessageError.builder()
                        .message(errorDatosException.getMessage()).build()));
    }

    @ExceptionHandler(RequiredDataException.class)
    ResponseEntity<MessageError> requiredDataException(RequiredDataException requiredDataException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body((MessageError.builder()
                        .message(requiredDataException.getMessage()).build()));
    }
}
