package com.ua.webdriver.edge;

import com.ua.webdriver.manager.Driver;
import com.ua.webdriver.model.WebDriverConfig;
import com.ua.webdriver.model.ProxyConfigHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.ua.webdriver.options.OptionsBuildFactory.getEdgeOptions;

public class EdgeWebDriver
        implements Driver {

    private final WebDriverConfig config;
    private final ProxyConfigHolder holder;

    public EdgeWebDriver(
            WebDriverConfig config,
            ProxyConfigHolder holder) {
        this.config = config;
        this.holder = holder;
    }

    @Override
    public void get(String action) {
        EdgeWebDriverHolder.INSTANCE.get(action);
    }

    @Override
    public void quit() {
        EdgeWebDriverHolder.INSTANCE.quit();
    }

    private static final class EdgeWebDriverHolder {
        private static final WebDriver INSTANCE =
                new EdgeDriver(getEdgeOptions());
    }

    public static WebDriver getInstance() {
        return EdgeWebDriverHolder.INSTANCE;
    }
}
