package com.ua.factory.transport.model;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.navigator.GpsNavigator;

public class Ship<T>
        extends Transport<T> {
    public Ship(
            Driver<T> driver,
            GpsNavigator<T> navigator) {
        super(driver, navigator);
    }

    @Override
    public void create() {
        new Ship<>(driver, navigator);
    }

    @Override
    public String toString() {
        return "Ship{driver=%s, navigator=%s}".formatted(
                driver.getClass().getSimpleName(),
                navigator.getClass().getSimpleName());
    }
}
