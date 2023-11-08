package com.classwork.pattern.creator;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class DriverFactory {

    private static final Map<Class<? extends Driver>, Driver> drivers = new HashMap<>();

    public static synchronized <T extends Driver> T getDriver(
            Class<T> driverClass,
            DriverConfig driverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        if (drivers.containsKey(driverClass)) {
            return driverClass.cast(drivers.get(driverClass));
        }

        try {
            Constructor<T> constructor = driverClass.getDeclaredConstructor(
                    DriverConfig.class, ProxyConfigHolder.class);
            T driver = constructor.newInstance(driverConfig, proxyConfigHolder);
            drivers.put(driverClass, driver);
            return driver;
        } catch (Exception e) {
            throw new WebDriverException("Failed to create: " + driverClass, e);
        }
    }
}
