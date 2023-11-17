package com.ua.factory.transport.driver;

public class ManualAutoDriver<T>
        extends ManualDrive<T> {

    @Override
    public Driver<T> create() {
        return new ManualAutoDriver<>();
    }
}
