package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BookIdNotFoundException.class, AuthorIdNotFoundException.class, PublisherIdNotFoundException.class, MemberIdNotFoundException.class})
    public ResponseEntity<String> handleIdNotFoundException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({BookTitleNotFoundException.class, MemberNameNotFoundException.class})
    public ResponseEntity<String> handleNameNotFoundException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
