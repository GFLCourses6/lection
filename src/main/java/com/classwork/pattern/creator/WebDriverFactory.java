package com.classwork.pattern.creator;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class WebDriverFactory {

    public static WebDriver createWebDriver(
            String browser,
            String gridUrl,
            String environmenturl) {
        WebDriver webDriver = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        try {
            if (gridUrl.isBlank()) {
                webDriver = switch (browser.toUpperCase()) {
                    case "CHROME" -> new ChromeDriver(chromeOptions);
                    case "EDGE" -> new EdgeDriver(edgeOptions);
                    case "FIREFOX" -> new FirefoxDriver(firefoxOptions);
                    default -> new ChromeDriver(chromeOptions);
                };
            } else {
                webDriver = switch (browser.toUpperCase()) {
                    case "CHROME" -> {
                        chromeOptions.setPageLoadStrategy(
                                PageLoadStrategy.NORMAL);
                        yield new RemoteWebDriver(new URL(gridUrl),
                                chromeOptions);
                    }
                    case "EDGE" -> {
                        edgeOptions.setPageLoadStrategy(
                                PageLoadStrategy.NORMAL);
                        yield new RemoteWebDriver(new URL(gridUrl),
                                edgeOptions);
                    }
                    case "FIREFOX" -> {
                        firefoxOptions.setPageLoadStrategy(
                                PageLoadStrategy.NORMAL);
                        yield new RemoteWebDriver(new URL(gridUrl),
                                firefoxOptions);
                    }
                    default -> new ChromeDriver(chromeOptions);
                };
            }

            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get(environmenturl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return webDriver;
    }
}

class ChromeDriverFactory
        implements Factory {
    @Override
    public WebDriver createWebDriver(
            String gridUrl,
            String environmenturl) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = null;
        try {
            if (gridUrl.isBlank()) {
                webDriver = new ChromeDriver(chromeOptions);
            } else {
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                webDriver = new RemoteWebDriver(new URL(gridUrl),
                        chromeOptions);
            }
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get(environmenturl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}

class EdgeDriverFactory
        implements Factory {
    @Override
    public WebDriver createWebDriver(
            String gridUrl,
            String environmenturl) {
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver webDriver = null;
        try {
            if (gridUrl.isBlank()) {
                webDriver = new EdgeDriver(edgeOptions);
            } else {
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                webDriver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
            }
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get(environmenturl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}

class FirefoxDriverFactory
        implements Factory {
    @Override
    public WebDriver createWebDriver(
            String gridUrl,
            String environmenturl) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver webDriver = null;
        try {
            if (gridUrl.isBlank()) {
                webDriver = new FirefoxDriver(firefoxOptions);
            } else {
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                webDriver = new RemoteWebDriver(new URL(gridUrl),
                        firefoxOptions);
            }
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get(environmenturl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}

