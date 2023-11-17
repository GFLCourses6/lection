package com.ua.webdriver.firefox;

import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class FirefoxOptionsService
        extends FirefoxOptions {

    private final WebDriverConfig webDriverConfig;
    private final ProxyConfigHolder proxyConfigHolder;

    public FirefoxOptionsService(
            WebDriverConfig webDriverConfig,
            ProxyConfigHolder proxyConfigHolder) {
        this.webDriverConfig = webDriverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FirefoxOptionsService that = (FirefoxOptionsService) o;
        return Objects.equals(webDriverConfig,
                that.webDriverConfig) && Objects.equals(proxyConfigHolder,
                that.proxyConfigHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), webDriverConfig, proxyConfigHolder);
    }
}
