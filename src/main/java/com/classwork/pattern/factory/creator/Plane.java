package com.classwork.pattern.factory.creator;

public abstract class Plane<T> implements Transport<T> {
    protected T driver;
    protected T navigator;

    protected Plane(T driver, T navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }
}