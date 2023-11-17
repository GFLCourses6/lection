package com.ua.webdriver.model;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;

public class WebDriverConfig {
    private String webDriverExecutable;
    private Map<String, String> userAgent;
    private Long implicitlyWait;
    private int port;

    public String getWebDriverExecutable() {
        return webDriverExecutable;
    }

    public Map<String, String> getUserAgent() {
        return userAgent;
    }

    public Duration getImplicitlyWait() {
        return Duration.ofSeconds(implicitlyWait);
    }

    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebDriverConfig that = (WebDriverConfig) o;
        return port == that.port && Objects.equals(webDriverExecutable,
                that.webDriverExecutable) && Objects.equals(userAgent,
                that.userAgent) && Objects.equals(implicitlyWait,
                that.implicitlyWait);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webDriverExecutable, userAgent, implicitlyWait, port);
    }
}