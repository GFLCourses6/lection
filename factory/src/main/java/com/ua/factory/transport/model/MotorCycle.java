package com.ua.factory.transport.model;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.navigator.GpsNavigator;

public class MotorCycle<T>
        extends Transport<T> {

    public MotorCycle(
            Driver<T> driver,
            GpsNavigator<T> navigator) {
        super(driver, navigator);
    }

    @Override
    public void create() {
        new MotorCycle<>(driver, navigator);
    }

    @Override
    public String toString() {
        return "MotorCycle{driver=%s, navigator=%s}".formatted(
                driver.getClass().getSimpleName(),
                navigator.getClass().getSimpleName());
    }
}
