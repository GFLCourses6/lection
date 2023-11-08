package com.classwork.pattern.creator.firefox;

import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class FirefoxOptionsService
        extends FirefoxOptions {

    private final DriverConfig driverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public FirefoxOptionsService(
            DriverConfig driverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.driverConfig = driverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FirefoxOptionsService that = (FirefoxOptionsService) o;
        return Objects.equals(driverConfig,
                that.driverConfig) && Objects.equals(proxyConfigHolder,
                that.proxyConfigHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverConfig, proxyConfigHolder);
    }
}
