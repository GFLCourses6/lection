package com.ua.structural.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected AbstractPage(WebDriverWait wait) {
        this.wait = wait;
    }

    protected WebElement findByXPath(String xpath) {
        return wait.until(visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void clearAndSendKeys(
            WebElement element,
            String text) {
        element.clear();
        element.sendKeys(text);
    }

    public abstract AbstractPage waitForSuggestions();

    public abstract void selectFirstSuggestedName();
}
