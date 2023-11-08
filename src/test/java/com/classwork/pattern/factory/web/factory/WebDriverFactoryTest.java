package com.classwork.pattern.factory.web.factory;

import com.classwork.pattern.creator.edge.EdgeWebDriver;
import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WebDriverFactoryTest {
    private DriverConfig config;
    private ProxyConfigHolder holder;
    private EdgeWebDriver edgeWebDriver;
    private final String site = "https://www.youtube.com/";

    @BeforeEach
    void setUp() {
        config = mock(DriverConfig.class);
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
        WebDriver webDriverMock = mock(WebDriver.class);
        webDriverMock.get(site);
        verify(webDriverMock).get(site);
        webDriverMock.quit();
        verify(webDriverMock).quit();
    }
}
