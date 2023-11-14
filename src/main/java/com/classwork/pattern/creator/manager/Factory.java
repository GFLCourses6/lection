package com.classwork.pattern.creator.manager;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface Factory {
    WebDriver createWebDriver(
            String gridUrl,
            String environmentUrl);

    default URL getUrl(String gridUrl) {
        try {
            return new URL(gridUrl);
        } catch (MalformedURLException e) {
            throw new WebDriverException(e);
        }
    }
}
