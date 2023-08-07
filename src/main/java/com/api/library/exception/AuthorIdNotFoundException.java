package com.api.library.exception;

import java.math.BigInteger;

public class AuthorIdNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No se encontró autor con el ID ";
    public AuthorIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
