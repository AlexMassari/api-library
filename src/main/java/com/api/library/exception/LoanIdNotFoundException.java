package com.api.library.exception;

import java.math.BigInteger;

public class LoanIdNotFoundException  extends RuntimeException{
    private static final String MESSAGE = "Loan not found with ID: ";
    public LoanIdNotFoundException(BigInteger id) {

        super(MESSAGE+id);
    }
}
