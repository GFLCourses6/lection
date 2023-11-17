package com.ua.factory.transport.driver;

public class ManualDrive<T>
        implements Driver<T> {
    @Override
    public Driver<T> create() {
        return new ManualDrive<>();
    }
}
