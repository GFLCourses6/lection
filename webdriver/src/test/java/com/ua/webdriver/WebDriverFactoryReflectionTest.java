package com.ua.webdriver;

import com.ua.webdriver.edge.EdgeWebDriver;
import com.ua.webdriver.model.ProxyConfigHolder;
import com.ua.webdriver.model.WebDriverConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WebDriverFactoryReflectionTest {
    private WebDriverConfig config;
    private ProxyConfigHolder holder;
    private EdgeWebDriver edgeWebDriver;
    private final String site = "https://www.youtube.com/";

    @BeforeEach
    void setUp() {
        config = mock(WebDriverConfig.class);
        holder = mock(ProxyConfigHolder.class);
        edgeWebDriver = mock(EdgeWebDriver.class);
    }

    @Test
    void testGets() {
        doNothing().when(edgeWebDriver).get(site);
        edgeWebDriver.get(site);
        verify(edgeWebDriver, times(1)).get(site);
    }

    @Test
    void testGetAndDestroy() {
        WebDriver webDriverMock = Mockito.mock(WebDriver.class);
        webDriverMock.get(site);
        verify(webDriverMock).get(site);
        webDriverMock.quit();
        verify(webDriverMock).quit();
    }
}
