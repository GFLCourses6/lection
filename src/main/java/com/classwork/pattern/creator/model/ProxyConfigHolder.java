package com.classwork.pattern.creator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProxyConfigHolder {
    private String username;
    private String password;
    private List<String> args;

    public List<String> getArgs() {
        this.args = Objects.requireNonNullElseGet(args,
                () -> new ArrayList<>(Arrays.asList(username, password)));
        return args;
    }
}
