package com.api.library.exception;

public class MemberNameNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No se encontró el nombre del socio ";

    public MemberNameNotFoundException(String name) {
        super(MESSAGE + name);
    }
}
