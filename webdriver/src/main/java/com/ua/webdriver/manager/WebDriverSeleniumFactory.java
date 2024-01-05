package com.ua.webdriver.manager;

import com.ua.webdriver.model.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class WebDriverSeleniumFactory {

    public static WebDriver initDriver(Browsers browser) {
        WebDriver driver = null;

        WebDriverManager.getInstance(browser.name()).setup();

        switch (browser) {
            case CHROME -> {
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", new File("downloads").getAbsolutePath());

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);

                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                driver = new EdgeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }
}