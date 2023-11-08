package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsBuildFactory {

    private static DriverConfig driverConfig;
    private static ProxyConfigHolder holder;

    public OptionsBuildFactory(
            DriverConfig driverConfig,
            ProxyConfigHolder holder) {
        OptionsBuildFactory.driverConfig = driverConfig;
        OptionsBuildFactory.holder = holder;
    }

    private static final class EdgeOptionsHolder {
        private static final EdgeOptions INSTANCE =
                new CreateEdgeOptions(driverConfig, holder);
    }

    private static final class FirefoxOptionsHolder {
        private static final FirefoxOptions INSTANCE =
                new CreateFirefoxOptions(driverConfig, holder);
    }

    private static final class ChromeOptionsHolder {
        private static final ChromeOptions INSTANCE =
                new CreateChromeOptions(driverConfig, holder);
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
