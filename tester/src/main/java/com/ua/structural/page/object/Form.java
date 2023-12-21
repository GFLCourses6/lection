package com.ua.structural.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Form {
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;


    public void fillForm(
            String username,
            String password) {
        clearAndSendKeys(usernameInput, username);
        clearAndSendKeys(passwordInput, password);
    }

    public void clearAndSendKeys(
            WebElement element,
            String text) {
        element.clear();
        element.sendKeys(text);
    }
}