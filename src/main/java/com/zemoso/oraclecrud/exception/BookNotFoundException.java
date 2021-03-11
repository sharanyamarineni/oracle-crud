package com.zemoso.oraclecrud.exception;


public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(final String message) {
        super(message);
    }
}
