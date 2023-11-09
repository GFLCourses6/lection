package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return Objects.equals(driver, transport.driver) && Objects.equals(
                navigator, transport.navigator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, navigator);
    }
}
