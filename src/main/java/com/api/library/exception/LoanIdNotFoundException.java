package com.api.library.exception;

import java.math.BigInteger;

public class LoanIdNotFoundException  extends RuntimeException{
    private static final String MESSAGE = "No se encontró prestamo con el ID ";
    public LoanIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
