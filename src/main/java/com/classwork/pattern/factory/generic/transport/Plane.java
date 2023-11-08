package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;

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
