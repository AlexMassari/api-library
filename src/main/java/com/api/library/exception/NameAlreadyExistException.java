package com.api.library.exception;

public class NameAlreadyExistException extends RuntimeException{
    public NameAlreadyExistException(String message) {
        super(message);
    }
}
