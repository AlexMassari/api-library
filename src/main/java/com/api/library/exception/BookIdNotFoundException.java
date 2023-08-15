package com.api.library.exception;

import java.math.BigInteger;

public class BookIdNotFoundException  extends RuntimeException{
    private static final String MESSAGE = "Book not found with ID: ";
    public BookIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
