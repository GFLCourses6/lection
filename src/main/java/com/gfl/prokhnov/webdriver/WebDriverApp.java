package com.gfl.prokhnov.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;
public class WebDriverApp {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "path to local webDriver");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://chromedriver.chromium.org/getting-started"); // URL of site
//        Sleep to load page
        Thread.sleep(5000);
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"h.p_ID_13\"]/span"));
        String currentText = element.getText();
        String expectedText = "Getting started";

        Assert.hasText(expectedText, currentText);

        webDriver.quit();



    }
}
