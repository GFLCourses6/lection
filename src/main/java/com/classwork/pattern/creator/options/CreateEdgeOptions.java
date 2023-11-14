package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.ProxyConfigHolder;
import com.classwork.pattern.creator.model.WebDriverConfig;
import org.openqa.selenium.edge.EdgeOptions;

public class CreateEdgeOptions
        extends EdgeOptions {
    public CreateEdgeOptions(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder proxyConfigHolder) {
    }
}
