package com.classwork.pattern.creator;

import org.openqa.selenium.WebDriver;

public interface Factory {
    WebDriver createWebDriver(String gridUrl, String environmenturl);
}
