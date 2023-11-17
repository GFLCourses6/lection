package com.ua.webdriver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverApp {
    public static void main(String[] args)
            throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver webDriver = new FirefoxDriver();
        webDriver.get("https://github.com/");
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a"));
//        String text = element.getText();
//        Assert.hasText("Get Started", text);
        //        element.sendKeys();
        element.click();
        webDriver.quit();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.readValue()
    }
}
