package com.classwork.pattern.creator.options;

import com.classwork.pattern.creator.model.ProxyConfigHolder;
import com.classwork.pattern.creator.model.DriverConfig;
import org.openqa.selenium.edge.EdgeOptions;

public class CreateEdgeOptions
        extends EdgeOptions {
    public CreateEdgeOptions(
            DriverConfig driverConfig,
            ProxyConfigHolder proxyConfigHolder) {
    }
}
