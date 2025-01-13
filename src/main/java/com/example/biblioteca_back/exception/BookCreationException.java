package com.example.biblioteca_back.exception;

public class BookCreationException extends RuntimeException {


    public BookCreationException(String message) {
        super(message);
    }


    public BookCreationException(String message, Throwable cause) {
        super(message, cause);
    }


    public BookCreationException(Throwable cause) {
        super(cause);
    }
}
