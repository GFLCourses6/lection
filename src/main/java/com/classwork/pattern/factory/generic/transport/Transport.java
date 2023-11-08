package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;

public abstract class Transport<T>
        implements Vehicle {

    protected Driver<T> driver;

    protected GpsNavigator<T> navigator;

    protected Transport(
            Driver<T> driver,
            GpsNavigator<T> navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }

    public void updateDriver(
            final Driver<T> driver) {
        this.driver = driver;
    }

    public void updateNavigator(
            final GpsNavigator<T> navigator) {
        this.navigator = navigator;
    }
}
