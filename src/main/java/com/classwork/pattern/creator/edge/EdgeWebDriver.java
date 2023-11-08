package com.classwork.pattern.creator.edge;

import com.classwork.pattern.creator.Driver;
import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.classwork.pattern.creator.options.OptionsBuildFactory.getEdgeOptions;

public class EdgeWebDriver
        implements Driver {

    private final DriverConfig config;
    private final ProxyConfigHolder holder;

    public EdgeWebDriver(
            DriverConfig config,
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
