package com.classwork.pattern.factory.generic.driver;

public class AutoDriver<T>
        implements Driver<T> {
    @Override
    public Driver<T> create() {
        return new AutoDriver<>();
    }
}
