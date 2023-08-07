package com.api.library.exception;

import java.math.BigInteger;

public class MemberIdNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No se encontró el ID ";
    public MemberIdNotFoundException(BigInteger id) {
        super(MESSAGE+id);
    }
}
