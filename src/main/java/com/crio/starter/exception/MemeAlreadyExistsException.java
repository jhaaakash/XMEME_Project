package com.crio.starter.exception;

public class MemeAlreadyExistsException extends RuntimeException {
    public MemeAlreadyExistsException(String message) {
        super(message);
    }
}

