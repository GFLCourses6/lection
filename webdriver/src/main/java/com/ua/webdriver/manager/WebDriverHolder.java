package com.ua.webdriver.manager;

import com.ua.webdriver.model.Browsers;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverHolder {

    static final Map<Long, WebDriver> driverMap = new HashMap<>();
    private static WebDriverHolder instance;

    private WebDriverHolder() {
        putDriverMap(Browsers.CHROME);
    }

    private static void putDriverMap(Browsers browser) {
        long threadId = Thread.currentThread().getId();
        driverMap.computeIfAbsent(threadId, k ->
                WebDriverInitializer.initDriver(browser));
    }

    public static synchronized WebDriverHolder getInstance(Browsers browser) {
        if (instance == null) {
            instance = new WebDriverHolder();
        } else {
            putDriverMap(browser);
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driverMap.get(Thread.currentThread().getId());
    }

    public void quitDriver() {
        long threadId = Thread.currentThread().getId();
        if (driverMap.containsKey(threadId)) {
            driverMap.get(threadId).quit();
            driverMap.remove(threadId);
        }
    }
}
