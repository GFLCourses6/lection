package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.WebDriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateChromeOptions
        extends ChromeOptions {
    public CreateChromeOptions(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder holder) {
    }
}
