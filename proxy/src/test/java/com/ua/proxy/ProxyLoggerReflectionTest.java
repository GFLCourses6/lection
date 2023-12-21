package com.ua.proxy;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.dto.LoginArgumentsProvider;
import com.ua.dto.model.entity.Customer;
import com.ua.proxy.logger.ProxyLoggerReflection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyLoggerReflectionTest {

    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    @DisplayName("Test print method with a User object")
    void testPrintWithSimpleObject(
            String url,
            String firstName,
            String lastName,
            Long id) {
        Customer customer = new Customer(id.intValue(), firstName, lastName);
        ProxyLoggerReflection logger = new ProxyLoggerReflection(customer);
        logger.print();
        assertEquals(customer.getName(), logger.getTree().get("name"));
        assertEquals(customer.getSurname(), logger.getTree().get("surname"));
        assertEquals(String.valueOf(customer.getId()), logger.getTree().get("id"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testReflectParams(String url, String loginName, String password,
                           Long timestamp) {
        Login login = new Login(url, loginName, password, timestamp);
        ProxyLoggerReflection logger = new ProxyLoggerReflection(login);
        assertEquals(loginName, logger.getTree().get("loginName"));
        assertEquals(password, logger.getTree().get("password"));
        assertEquals(String.valueOf(timestamp), logger.getTree().get("timestamp"));
    }
}
