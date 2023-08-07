package com.api.library.exception;

import java.math.BigInteger;

public class PublisherIdNotFoundException extends RuntimeException{
    private static final String MESSAGE = "No se encontró la editorial con el id ";
    public PublisherIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}

