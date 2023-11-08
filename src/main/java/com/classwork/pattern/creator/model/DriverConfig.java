package com.classwork.pattern.creator.model;

import java.time.Duration;
import java.util.Map;

public class DriverConfig {
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
}