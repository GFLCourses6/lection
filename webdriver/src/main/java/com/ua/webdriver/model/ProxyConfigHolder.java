package com.ua.webdriver.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProxyConfigHolder {
    private String username;
    private String password;
    private List<String> arguments;

    public List<String> getArgs() {
        this.arguments = Objects.requireNonNullElseGet(arguments,
                () -> new ArrayList<>(Arrays.asList(username, password)));
        return arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyConfigHolder that = (ProxyConfigHolder) o;
        return Objects.equals(username, that.username) && Objects.equals(
                password, that.password) && Objects.equals(arguments,
                that.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, arguments);
    }
}
