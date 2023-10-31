package com.classwork.pattern.proxy;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.proxy.logger.ProxyLogger;
import com.classwork.pattern.proxy.logger.ProxyLoggerPrinter;
import com.classwork.pattern.proxy.logger.ProxyLoggerReflection;

public class ProxyApp {

    public static void main(String[] args) {

        Login login = new Login("Jack", "Sparrow", 100L);
        ProxyLogger logger = new ProxyLoggerReflection(login);
        logger = new ProxyLoggerPrinter(logger, login);
        logger.print();
    }
}
