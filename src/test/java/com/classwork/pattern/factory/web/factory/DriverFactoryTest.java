package com.classwork.pattern.factory.web.factory;

import com.classwork.pattern.creator.Driver;
import com.classwork.pattern.creator.chrome.ChromeWebDriver;
import com.classwork.pattern.creator.firefox.FirefoxWebDriver;
import com.classwork.pattern.creator.model.DriverConfig;
import com.classwork.pattern.creator.model.ProxyConfigHolder;

import static com.classwork.pattern.creator.DriverFactory.getDriver;

class DriverFactoryTest {

    void testCreateDriver() {
        DriverConfig config = new DriverConfig();
        ProxyConfigHolder holder = new ProxyConfigHolder();
        Driver firefox = getDriver(FirefoxWebDriver.class, config, holder);
        firefox.get("https://www.youtube.com/");
        firefox.quit();
        Driver chromeDriver = getDriver(ChromeWebDriver.class, config, holder);
        chromeDriver.get("https://www.youtube.com/");
        chromeDriver.quit();
    }
}