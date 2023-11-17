package com.ua.webdriver.options;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public abstract class OptionsFactory {
    public abstract EdgeOptions createEdgeOptions();

    public abstract FirefoxOptions createFirefoxOptions();

    public abstract ChromeOptions createChromeOptions();
}
