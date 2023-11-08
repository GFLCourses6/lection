package com.classwork.pattern.factory.generic.driver;

public class SmartAutoDriver<T>
        extends AutoDriver<T> {

    @Override
    public Driver<T> create() {
        return new SmartAutoDriver<>();
    }
}
