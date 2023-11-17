package com.ua.factory.transport.driver;

public class AutoDriver<T>
        implements Driver<T> {
    @Override
    public Driver<T> create() {
        return new AutoDriver<>();
    }
}
