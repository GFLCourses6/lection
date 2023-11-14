package com.classwork.pattern.creator.manager;

public class WebDriverException
        extends RuntimeException {
    public WebDriverException(
            String message,
            Throwable e) {
        super(message, e);
    }

    public WebDriverException(
            Throwable e) {
        super(e);
    }

    public WebDriverException(
            String message) {
        super(message);
    }
}
