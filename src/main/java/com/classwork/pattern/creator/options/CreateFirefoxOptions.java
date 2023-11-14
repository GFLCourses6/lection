package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.WebDriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreateFirefoxOptions
        extends FirefoxOptions {
    public CreateFirefoxOptions(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder holder) {
    }
}
