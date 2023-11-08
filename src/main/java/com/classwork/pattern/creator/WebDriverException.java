package com.classwork.pattern.creator;

public class WebDriverException
        extends RuntimeException {
    public WebDriverException(
            String message,
            Throwable e) {
        super(message, e);
    }
}
