package com.classwork.pattern.creator.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FactoryTest {

    @Mock
    WebDriver mockDriver;
    @Mock
    WebDriver.Options mockOptions;
    @Mock
    WebDriver.Window mockWindow;

    private AutoCloseable closeable;
    String environmentUrl = "http://localhost:4200";
    String gridUrl = "http://localhost:4200/main/1";

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        when(mockDriver.manage()).thenReturn(mockOptions);
        when(mockOptions.window()).thenReturn(mockWindow);
    }

    @AfterEach
    public void cleanUp()
            throws Exception {
        closeable.close();
    }

    @Test
    void testGetUrl() {
        Factory factory = mock(Factory.class, CALLS_REAL_METHODS);
        URL url = factory.getUrl(gridUrl);
        assertEquals(gridUrl, url.toString());
    }

    @Test
    void testGetUrlThrowsException() {
        String gridUrl = "malformed url";
        Factory factory = mock(Factory.class, CALLS_REAL_METHODS);
        assertThrows(WebDriverException.class, () -> factory.getUrl(gridUrl));
    }
}
