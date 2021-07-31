package com.plants.journal.exception;

public class IllegalUserAccessException extends RuntimeException {
    public IllegalUserAccessException() {
    }

    public IllegalUserAccessException(String message) {
        super(message);
    }
}
