package com.ua.proxy.logger;

public class ProxyLoggerPrinter implements ProxyLogger {
    private ProxyLogger proxy;
    private final Object object;

    public ProxyLoggerPrinter(ProxyLogger proxyLogger, Object object) {
        this.proxy = proxyLogger;
        this.object = object;
    }

    @Override
    public void print() {
        if (proxy == null) {
            proxy = new ProxyLoggerReflection(object);
        }
        proxy.print();
    }
}
