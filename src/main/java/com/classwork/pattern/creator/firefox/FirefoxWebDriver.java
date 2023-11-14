package com.classwork.pattern.creator.firefox;

import com.classwork.pattern.creator.manager.Driver;
import com.classwork.pattern.creator.model.WebDriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxWebDriver
        implements Driver {

    private static WebDriverConfig config;
    private static ProxyConfigHolder holder;

    public FirefoxWebDriver(
            WebDriverConfig config,
            ProxyConfigHolder holder) {
        FirefoxWebDriver.config = config;
        FirefoxWebDriver.holder = holder;
    }

    @Override
    public void get(String action) {
        FirefoxWebDriverHolder.INSTANCE.get(action);
    }

    @Override
    public void quit() {
        FirefoxWebDriverHolder.INSTANCE.quit();
    }

    private static final class FirefoxWebDriverHolder {
        private static final WebDriver INSTANCE =
                new FirefoxDriver(new FirefoxOptionsService(config, holder));
    }

    public static WebDriver getInstance() {
        return FirefoxWebDriverHolder.INSTANCE;

    }
}
