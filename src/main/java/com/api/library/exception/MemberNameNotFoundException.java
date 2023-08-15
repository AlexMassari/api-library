package com.api.library.exception;

public class MemberNameNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Member not found with name: ";

    public MemberNameNotFoundException(String name) {
        super(MESSAGE + name);
    }
}
