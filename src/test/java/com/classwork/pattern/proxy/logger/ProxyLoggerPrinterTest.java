package com.classwork.pattern.proxy.logger;

import com.classwork.pattern.dto.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProxyLoggerPrinterTest {

    private Object object;
    private ProxyLogger proxyLogger;
    private ProxyLogger proxyPrinter;
    private ProxyLogger realProxy;

    @BeforeEach
    public void setUp() {
        object = new Object();
        proxyLogger = mock(ProxyLogger.class);
        realProxy = mock(ProxyLoggerReflection.class);
        proxyPrinter = new ProxyLoggerPrinter(proxyLogger, object);
    }

    @Test
    @DisplayName("Test print method with non-null  mock ProxyLogger")
    void testPrintWithNonNullProxy() {
        proxyPrinter.print();
        verify(proxyLogger, times(1)).print();
    }

    @Test
    @DisplayName("Test print method with null real ProxyLoggerPrinter")
    void testPrintWithNotNullProxy() {
        ProxyLoggerPrinter printerWithMockProxy = new ProxyLoggerPrinter(realProxy, object);
        printerWithMockProxy.print();
        verify(realProxy, times(1)).print();
    }

    @Test
    @DisplayName("Test print method with null proxy")
    void testPrintWithNullProxy() {
        User user = new User("Will" , "Turner");
        ProxyLoggerReflection realProxy = new ProxyLoggerReflection(user);
        ProxyLoggerReflection spyProxy = spy(realProxy);
        ProxyLoggerPrinter loggerPrinter = new ProxyLoggerPrinter(spyProxy, user);
        loggerPrinter.print();
        verify(spyProxy, times(1)).print();
    }
}
