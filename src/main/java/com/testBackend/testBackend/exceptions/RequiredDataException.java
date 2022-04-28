package com.testBackend.testBackend.exceptions;

public class RequiredDataException extends RuntimeException{
    public RequiredDataException(String message) {
        super(message);
    }
}
