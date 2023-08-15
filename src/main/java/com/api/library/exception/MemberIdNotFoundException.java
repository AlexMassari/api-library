package com.api.library.exception;

import java.math.BigInteger;

public class MemberIdNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Member not found with ID: ";
    public MemberIdNotFoundException(BigInteger id) {
        super(MESSAGE+id);
    }
}
