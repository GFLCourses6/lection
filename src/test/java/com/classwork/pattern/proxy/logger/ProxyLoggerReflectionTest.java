package com.classwork.pattern.proxy.logger;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.dto.model.entity.User;
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
            String firstName,
            String lastName,
            Long id) {
        User user = new User(id.intValue(), firstName, lastName);
        ProxyLoggerReflection logger = new ProxyLoggerReflection(user);
        logger.print();
        assertEquals(user.getName(), logger.getTree().get("name"));
        assertEquals(user.getSurname(), logger.getTree().get("surname"));
        assertEquals(String.valueOf(user.getId()), logger.getTree().get("id"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @ArgumentsSource(LoginArgumentsProvider.class)
    void testReflectParams(String loginName, String password, Long timestamp) {
        Login login = new Login(loginName, password, timestamp);
        ProxyLoggerReflection logger = new ProxyLoggerReflection(login);
        assertEquals(loginName, logger.getTree().get("loginName"));
        assertEquals(password, logger.getTree().get("password"));
        assertEquals(String.valueOf(timestamp), logger.getTree().get("timestamp"));
    }
}
