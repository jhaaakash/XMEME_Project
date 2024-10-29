package com.crio.starter.exception;

public class InvalidMemeDataException extends RuntimeException {
    public InvalidMemeDataException(String message) {
        super(message);
    }
}
