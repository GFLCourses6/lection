package com.ua.webdriver.manager;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.function.Function;
import java.util.function.Supplier;


public class DriverFactory<T extends AbstractDriverOptions<T>, R extends RemoteWebDriver>
        implements Factory {
    private final Supplier<T> optionsSupplier;
    private final Function<T, R> driverFunction;
    private final Function<URL, R> remoteWebDriver;

    public DriverFactory(
            Supplier<T> optionsSupplier,
            Function<T, R> driverFunction,
            Function<URL, R> remoteWebDriver) {
        this.optionsSupplier = optionsSupplier;
        this.driverFunction = driverFunction;
        this.remoteWebDriver = remoteWebDriver;
    }

    @Override
    public WebDriver createWebDriver(
            String gridUrl,
            String environmentUrl) {

        WebDriver webDriver;
        T options = optionsSupplier.get();

        if (gridUrl.isBlank()) {
            webDriver = driverFunction.apply(options);
        } else {
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            webDriver = remoteWebDriver.apply(getUrl(gridUrl));
        }

        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.get(environmentUrl);

        return webDriver;
    }
}
