package com.classwork.pattern.factory.web.factory;

import com.classwork.pattern.creator.firefox.FirefoxWebDriver;
import com.classwork.pattern.creator.manager.Driver;
import com.classwork.pattern.creator.manager.DriverFactory;
import com.classwork.pattern.creator.manager.ProviderFactory;
import com.classwork.pattern.creator.model.ProxyConfigHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.classwork.pattern.creator.manager.DriverFactoryReflection.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DriverFactoryTest {

    @Mock
    RemoteWebDriver driver;
    @Mock
    FirefoxOptions firefoxOptions;
    @Mock
    WebDriver.Options mockOptions;
    @Mock
    WebDriver.Window mockWindow;
    @Mock
    Supplier<FirefoxOptions> optionsSupplier;
    @Mock
    Function<URL, RemoteWebDriver> remoteWebDriver;
    @Mock
    Function<FirefoxOptions, RemoteWebDriver> driverFunction;
    private AutoCloseable closeable;
    String environmentUrl;
    String gridUrl;

    @BeforeEach
    public void setup() {
        environmentUrl = "https://www.youtube.com/";
        gridUrl = environmentUrl + "/user/playlist";
        closeable = MockitoAnnotations.openMocks(this);
        when(mockOptions.window()).thenReturn(mockWindow);
        when(driver.manage()).thenReturn(mockOptions);
        when(optionsSupplier.get()).thenReturn(firefoxOptions);
        when(driverFunction.apply(firefoxOptions)).thenReturn(driver);
    }

    @AfterEach
    public void cleanUp()
            throws Exception {
        closeable.close();
    }

    @Test
    void testCreateWebDriverFirefoxOptions()
            throws MalformedURLException {
        when(remoteWebDriver.apply(new URL(gridUrl))).thenReturn(driver);
        DriverFactory<FirefoxOptions, RemoteWebDriver> factory =
                new DriverFactory<>(optionsSupplier, driverFunction,
                        remoteWebDriver);
        WebDriver webDriver = factory.createWebDriver(gridUrl, environmentUrl);
        assertTrue(webDriver instanceof RemoteWebDriver);
        assertEquals(driver, webDriver);
        verify(optionsSupplier, times(1)).get();
        verify(driverFunction, times(0)).apply(firefoxOptions);
        verify(remoteWebDriver, times(1)).apply(new URL(gridUrl));
        verify(driver, times(2)).manage();
        verify(mockOptions, times(1)).deleteAllCookies();
        verify(mockWindow, times(1)).maximize();
        verify(driver, times(1)).get(environmentUrl);
        verify(mockOptions).deleteAllCookies();
        verify(mockWindow).maximize();
        verify(webDriver).get(environmentUrl);
    }

    @Test
    void testCreateWebDriverEdgeDriverWithNonBlankGridUrl()
            throws MalformedURLException {
        when(remoteWebDriver.apply(new URL(gridUrl))).thenReturn(driver);
        DriverFactory<FirefoxOptions, RemoteWebDriver> factory =
                new DriverFactory<>(optionsSupplier, driverFunction,
                        remoteWebDriver);
        ProviderFactory mockProviderFactory =
                Mockito.mock(ProviderFactory.class);
        when(mockProviderFactory.getFactory("EdgeDriver")).thenReturn(factory);
        WebDriver webDriver = mockProviderFactory
                .getFactory("EdgeDriver")
                .createWebDriver(gridUrl, environmentUrl);
        assertEquals(driver, webDriver);
        assertTrue(webDriver instanceof RemoteWebDriver);
        verify(optionsSupplier, times(1)).get();
        verify(driverFunction, times(0)).apply(firefoxOptions);
        verify(remoteWebDriver, times(1)).apply(new URL(gridUrl));
        verify(driver, times(2)).manage();
        verify(mockOptions, times(1)).deleteAllCookies();
        verify(mockWindow, times(1)).maximize();
        verify(driver, times(1)).get(environmentUrl);
        verify(mockOptions).deleteAllCookies();
        verify(mockWindow).maximize();
        verify(webDriver).get(environmentUrl);
    }
}
