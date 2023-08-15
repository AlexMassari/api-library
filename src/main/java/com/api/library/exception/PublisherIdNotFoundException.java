package com.api.library.exception;

import java.math.BigInteger;

public class PublisherIdNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Publisher not found with ID: ";
    public PublisherIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}

