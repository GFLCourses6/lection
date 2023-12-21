package com.ua.proxy;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.dto.LoginArgumentsProvider;
import com.ua.dto.model.entity.Customer;
import com.ua.proxy.logger.ProxyLogger;
import com.ua.proxy.logger.ProxyLoggerPrinter;
import com.ua.proxy.logger.ProxyLoggerReflection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        Customer customer = new Customer("Will" , "Turner");
        ProxyLoggerReflection realProxy = new ProxyLoggerReflection(customer);
        ProxyLoggerReflection spyProxy = spy(realProxy);
        ProxyLoggerPrinter loggerPrinter = new ProxyLoggerPrinter(spyProxy,
                customer);
        loggerPrinter.print();
        verify(spyProxy, times(1)).print();
    }
    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testProxyLogger(String url, String firstName, String lastName, Long id) {
        Login login = new Login(url, firstName, lastName, id);
        ProxyLogger logger = new ProxyLoggerReflection(login);
        logger = new ProxyLoggerPrinter(logger, login);
        assertDoesNotThrow(logger::print);
    }

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testPrint(String url,String firstName, String lastName, Long id) {
        Login login = new Login(url, firstName, lastName, id);
        ProxyLogger proxyLogger = new ProxyLoggerReflection(login);
        ProxyLoggerPrinter printer = new ProxyLoggerPrinter(proxyLogger, login);
        assertDoesNotThrow(printer::print);
        printer = new ProxyLoggerPrinter(null, login);
        assertDoesNotThrow(printer::print);
    }
}
