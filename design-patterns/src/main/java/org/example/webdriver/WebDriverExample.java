package org.example.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;

public class WebDriverExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\alex\\Downloads\\chromedriver-win64"); // manual config
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://chromedriver.chromium.org/getting-started"); // testing site url
        Thread.sleep(5000); // waiting for the site to fully load
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"h.p_ID_13\"]/span")); // test that element
        String text = element.getText();
        Assert.hasText("Getting started", text);
        webDriver.quit();
    }
}
