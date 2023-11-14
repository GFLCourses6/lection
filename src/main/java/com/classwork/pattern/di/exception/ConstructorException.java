package com.classwork.pattern.di.exception;

public class ConstructorException
        extends RuntimeException {
    public ConstructorException(Throwable e) {
        super(e);
    }

    public ConstructorException(String message) {
        super(message);
    }
}
