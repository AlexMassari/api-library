package com.api.library.exception;

import java.math.BigInteger;

public class AuthorIdNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Author not found with ID: ";
    public AuthorIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
