package com.api.library.exception;

public class BookTitleNotFoundException extends RuntimeException{
    private static final String MESSAGE = "No se encontró el título ";
    public BookTitleNotFoundException(String title) {
        super(MESSAGE+title);
    }
}
