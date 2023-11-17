package com.ua.factory.transport.model;


import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.navigator.GpsNavigator;

public class Plane<T>
        extends Transport<T> {

    public Plane(
            Driver<T> driver,
            GpsNavigator<T> navigator) {
        super(driver, navigator);
    }

    @Override
    public void create() {
        new Plane<>(driver, navigator);
    }

    @Override
    public String toString() {
        return "Plane{driver=%s, navigator=%s}".formatted(
                driver.getClass().getSimpleName(),
                navigator.getClass().getSimpleName());
    }
}
