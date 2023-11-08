package com.classwork.pattern.creator.chrome;

import com.classwork.pattern.creator.model.ProxyConfigHolder;
import com.classwork.pattern.creator.Driver;
import com.classwork.pattern.creator.model.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver
        implements Driver {

    private final DriverConfig driverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public ChromeWebDriver(
            DriverConfig driverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.driverConfig = driverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
    }

    @Override
    public void get(String action) {
        ChromeWebDriverHolder.INSTANCE.get(action);
    }

    @Override
    public void quit() {
        ChromeWebDriverHolder.INSTANCE.quit();
    }

    private static final class ChromeWebDriverHolder {
        private static final WebDriver INSTANCE =
                new ChromeDriver(new ChromeOptionsService());
    }

    public static WebDriver getInstance() {
        return ChromeWebDriverHolder.INSTANCE;

    }
}
