package com.ua.webdriver.chrome;

import com.ua.webdriver.manager.Driver;
import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver
        implements Driver {

    private final WebDriverConfig webDriverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public ChromeWebDriver(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.webDriverConfig = webDriverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
    }

    @Override
    public void get(String action) {
        ChromeWebDriverHolder.INSTANCE.get(action);
    }

    @Override
    public void quit() {
        ChromeWebDriverHolder.INSTANCE.quit();
    }

    private static final class ChromeWebDriverHolder {
        private static final WebDriver INSTANCE =
                new ChromeDriver(new ChromeOptionsService());
    }

    public static WebDriver getInstance() {
        return ChromeWebDriverHolder.INSTANCE;

    }
}
