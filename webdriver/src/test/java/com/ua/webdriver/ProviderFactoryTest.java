package com.ua.webdriver;

import com.ua.webdriver.manager.DriverFactory;
import com.ua.webdriver.manager.Factory;
import com.ua.webdriver.manager.ProviderFactory;
import com.ua.webdriver.manager.WebDriverException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.function.Function;

import static com.ua.webdriver.model.Browsers.CHROME;
import static com.ua.webdriver.model.Browsers.EDGE;
import static com.ua.webdriver.model.Browsers.FIREFOX;
import static com.ua.webdriver.model.Browsers.INVALID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProviderFactoryTest {

    @Mock
    EdgeDriver mockEdgeDriver;
    @Mock
    FirefoxDriver mockFirefoxDriver;
    @Mock
    ChromeDriver mockChromeDriver;
    @Mock
    WebDriver.Window mockWindow;
    @Mock
    WebDriver.Options mockOptions;
    @Mock
    Function<URL, RemoteWebDriver> remoteWebDriver;
    @Mock
    WebDriver mockDriver;
    @Mock
    ChromeOptions mockChromeOptions;
    private String environmentUrl;
    private AutoCloseable closeable;
    private ProviderFactory providerFactory;
    private String gridUrl;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        when(mockDriver.manage()).thenReturn(mockOptions);
        when(mockOptions.window()).thenReturn(mockWindow);
        environmentUrl = "https://www.youtube.com/";
        gridUrl = environmentUrl + "/@DevoxxForever";
        closeable = MockitoAnnotations.openMocks(this);
        providerFactory = new ProviderFactory();
    }

    @AfterEach
    public void cleanUp()
            throws Exception {
        closeable.close();
    }

//    @Test
    void testCreateWebDriverEdgeDriverWithBlankGridUrl() {
        when(mockEdgeDriver.manage()).thenReturn(mockOptions);
        when(mockOptions.window()).thenReturn(mockWindow);
        WebDriver driver = providerFactory
                .getFactory(EDGE)
                .createWebDriver("", environmentUrl);
        assertTrue(driver instanceof EdgeDriver);
                verify(mockOptions).deleteAllCookies();
                verify(mockWindow).maximize();
                verify(mockEdgeDriver).get(environmentUrl);
    }

    @Test
    void testGetFactory() {
        ProviderFactory providerFactory = new ProviderFactory();
        Factory edgeDriver = providerFactory.getFactory(EDGE);
        assertTrue(edgeDriver instanceof DriverFactory);
        Factory chromeDriver = providerFactory.getFactory(CHROME);
        assertTrue(chromeDriver instanceof DriverFactory);
        Factory firefoxDriver = providerFactory.getFactory(FIREFOX);
        assertTrue(firefoxDriver instanceof DriverFactory);
    }

    @Test
    void testGetFactoryWithInvalidBrowserType() {
        ProviderFactory providerFactory = new ProviderFactory();
        assertThrows(WebDriverException.class,
                () -> providerFactory.getFactory(INVALID));
    }
}
