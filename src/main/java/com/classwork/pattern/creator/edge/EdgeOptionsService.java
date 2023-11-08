package com.classwork.pattern.creator.edge;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class EdgeOptionsService
        extends EdgeOptions {

    private final DriverConfig driverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public EdgeOptionsService(
            DriverConfig driverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.driverConfig = driverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
        this.addArguments("--remote-allow-origins=*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EdgeOptionsService that = (EdgeOptionsService) o;
        return Objects.equals(driverConfig,
                that.driverConfig) && Objects.equals(proxyConfigHolder,
                that.proxyConfigHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverConfig, proxyConfigHolder);
    }
}
