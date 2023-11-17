package com.ua.factory.transport.model;

public class UnSupportException
        extends IllegalArgumentException {
    public UnSupportException(
            final String message) {
        super(message);
    }
}
