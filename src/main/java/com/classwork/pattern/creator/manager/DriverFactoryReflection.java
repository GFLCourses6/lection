package com.classwork.pattern.creator.manager;

import com.classwork.pattern.creator.model.WebDriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DriverFactoryReflection {

    private DriverFactoryReflection() {
    }

    private static final Map<Class<? extends Driver>, Driver> drivers = new HashMap<>();

    public static synchronized <T extends Driver> T getDriver(
            Class<T> driverClass,
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        if (drivers.containsKey(driverClass)) {
            return driverClass.cast(drivers.get(driverClass));
        }

        try {
            Constructor<T> constructor = driverClass.getDeclaredConstructor(
                    WebDriverConfig.class, ProxyConfigHolder.class);
            T driver = constructor.newInstance(webDriverConfig, proxyConfigHolder);
            drivers.put(driverClass, driver);
            return driver;
        } catch (Exception e) {
            throw new WebDriverException("Failed to create: " + driverClass, e);
        }
    }
}
