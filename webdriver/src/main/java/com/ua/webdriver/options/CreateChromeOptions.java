package com.ua.webdriver.options;

import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateChromeOptions
        extends ChromeOptions {
    public CreateChromeOptions(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder holder) {
    }
}
