package com.classwork.pattern.proxy.logger;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.dto.model.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProxyLoggerReflectionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("Test print method ProxyLoggerReflection with a Login object")
    void testProxy() {
        Login login = new Login("Jack", "Sparrow", 100L);
        ProxyLogger logger = new ProxyLoggerReflection(login);
        logger = new ProxyLoggerPrinter(logger, login);
        logger.print();
        String expectedOutput = "{password=Sparrow, login=Jack, timestamp=100}\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Test print method with a User object")
    void testPrint_WithSimpleObject() {
        User user =new User("Will" , "Turner");
        ProxyLoggerReflection proxyLoggerReflection = new ProxyLoggerReflection(user);
        proxyLoggerReflection.print();
        String expected = "surname=Turner, name=Will";
        assertTrue(outContent.toString().contains(expected));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
