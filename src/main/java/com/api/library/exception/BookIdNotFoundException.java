package com.api.library.exception;

import java.math.BigInteger;

public class BookIdNotFoundException  extends RuntimeException{
    private static final String MESSAGE = "No se encontró el ID ";
    public BookIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
