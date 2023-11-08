package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateChromeOptions
        extends ChromeOptions {
    public CreateChromeOptions(
            DriverConfig driverConfig,
            ProxyConfigHolder holder) {
    }
}
