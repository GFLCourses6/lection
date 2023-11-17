package com.ua.webdriver.options;

import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsBuildFactory {

    private static WebDriverConfig webDriverConfig;
    private static ProxyConfigHolder holder;

    public OptionsBuildFactory(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder holder) {
        OptionsBuildFactory.webDriverConfig = webDriverConfig;
        OptionsBuildFactory.holder = holder;
    }

    private static final class EdgeOptionsHolder {
        private static final EdgeOptions INSTANCE =
                new CreateEdgeOptions(webDriverConfig, holder);
    }

    private static final class FirefoxOptionsHolder {
        private static final FirefoxOptions INSTANCE =
                new CreateFirefoxOptions(webDriverConfig, holder);
    }

    private static final class ChromeOptionsHolder {
        private static final ChromeOptions INSTANCE =
                new CreateChromeOptions(webDriverConfig, holder);
    }

    public static EdgeOptions getEdgeOptions() {
        return EdgeOptionsHolder.INSTANCE;
    }

    public static FirefoxOptions getFirefoxOptions() {
        return FirefoxOptionsHolder.INSTANCE;
    }

    public static ChromeOptions getChromeOptions() {
        return ChromeOptionsHolder.INSTANCE;
    }
}
