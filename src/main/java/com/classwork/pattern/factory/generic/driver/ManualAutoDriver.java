package com.classwork.pattern.factory.generic.driver;

public class ManualAutoDriver<T>
        extends AutoDriver<T> {

    @Override
    public Driver<T> create() {
        return new ManualAutoDriver<>();
    }
}
