package com.ua.webdriver.edge;

import com.ua.webdriver.model.WebDriverConfig;
import com.ua.webdriver.model.ProxyConfigHolder;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class EdgeOptionsService
        extends EdgeOptions {

    private final WebDriverConfig webDriverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public EdgeOptionsService(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.webDriverConfig = webDriverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
        this.addArguments("--remote-allow-origins=*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EdgeOptionsService that = (EdgeOptionsService) o;
        return Objects.equals(webDriverConfig,
                that.webDriverConfig) && Objects.equals(proxyConfigHolder,
                that.proxyConfigHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), webDriverConfig, proxyConfigHolder);
    }
}
