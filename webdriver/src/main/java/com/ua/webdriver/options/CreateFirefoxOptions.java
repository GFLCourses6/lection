package com.ua.webdriver.options;

import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreateFirefoxOptions
        extends FirefoxOptions {
    public CreateFirefoxOptions(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder holder) {
    }
}
