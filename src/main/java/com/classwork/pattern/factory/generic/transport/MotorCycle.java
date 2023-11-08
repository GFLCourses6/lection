package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;

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
