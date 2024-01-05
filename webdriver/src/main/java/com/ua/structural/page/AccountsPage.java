package com.ua.structural.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AccountsPage
        extends AbstractPage {

    @CacheLookup
    @FindBy(id = "user")
    private WebElement userName;

    @CacheLookup
    private WebElement amount;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Create']")
    private WebElement createButton;

    @FindBy(xpath = "//ul[@class='suggestions']")
    private WebElement suggestionDropdown;

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AccountsPage waitForSuggestions() {
        WebElement suggestionsContainer =
                driver.findElement(By.id("suggestionsContainer"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        wait.until(visibilityOf(suggestionsContainer));
        return this;
    }

    @Override
    public void selectFirstSuggestedName() {
        WebElement firstSuggestion =
                driver.findElement(By.xpath("//ul[@class='suggestions']/li[1]"));
        //        clickElement(firstSuggestion);
    }


    public AccountsPage registerAccount(
            String name,
            double money) {
        userName.sendKeys(name);
        amount.sendKeys(Double.toString(money));
        createButton.click();
        return new AccountsPage(driver);
    }

    public AccountsPage typeFirstLetterOfName(String letter) {
        userName.sendKeys(letter);
        return this;
    }


    public String getRegisteredUserId(int index) {
        return findByXPath("//tbody/tr[" + index + "1/td[1]").getText();
    }

    public String getUserName() {
        return userName.getText();
    }
}
