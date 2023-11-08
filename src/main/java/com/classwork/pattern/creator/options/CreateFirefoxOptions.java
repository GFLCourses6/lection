package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreateFirefoxOptions
        extends FirefoxOptions {
    public CreateFirefoxOptions(
            DriverConfig driverConfig,
            ProxyConfigHolder holder) {
    }
}
