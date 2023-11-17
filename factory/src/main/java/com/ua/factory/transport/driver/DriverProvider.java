package com.ua.factory.transport.driver;

public class DriverProvider<T> {
    Driver<T> auto;
    Driver<T> manual;

    public DriverProvider() {
        this.manual = new ManualAutoDriver<>();
        this.auto = new SmartAutoDriver<>();
    }
}
