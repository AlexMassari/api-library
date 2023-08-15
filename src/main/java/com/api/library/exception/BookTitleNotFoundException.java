package com.api.library.exception;

public class BookTitleNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Book not found with title: ";
    public BookTitleNotFoundException(String title) {
        super(MESSAGE+title);
    }
}
