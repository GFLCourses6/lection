package com.ua.webdriver.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.ua.webdriver.model.BrowserDriver.CHROME;
import static com.ua.webdriver.model.BrowserDriver.EDGE;
import static com.ua.webdriver.model.BrowserDriver.FIREFOX;

public class ProviderFactory {

    public Factory getFactory(String browserType) {
        return switch (browserType) {
            case EDGE -> getDriverFactory();
            case CHROME -> getChromeDriverFactory();
            case FIREFOX -> getFirefoxDriverFactory();
            default -> throw new WebDriverException(
                    "Invalid browser type: " + browserType);
        };
    }

    private static DriverFactory<ChromiumOptions<?>, RemoteWebDriver> getDriverFactory() {
        return new DriverFactory<>(EdgeOptions::new,
                options -> new EdgeDriver((EdgeOptions) options),
                url -> new RemoteWebDriver(url, new EdgeOptions()));
    }

    private static DriverFactory<ChromiumOptions<?>, RemoteWebDriver> getChromeDriverFactory() {
        return new DriverFactory<>(ChromeOptions::new,
                options -> new ChromeDriver((ChromeOptions) options),
                url -> new RemoteWebDriver(url, new ChromeOptions()));
    }

    private static DriverFactory<FirefoxOptions, RemoteWebDriver> getFirefoxDriverFactory() {
        return new DriverFactory<>(FirefoxOptions::new, FirefoxDriver::new,
                url -> new RemoteWebDriver(url, new FirefoxOptions()));
    }
}
