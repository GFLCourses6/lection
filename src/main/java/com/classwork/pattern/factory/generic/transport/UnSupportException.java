package com.classwork.pattern.factory.generic.transport;

public class UnSupportException
        extends IllegalArgumentException {
    public UnSupportException(
            final String message) {
        super(message);
    }
}
