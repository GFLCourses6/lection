package com.ua.structural.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MainPage
        extends LoadableComponent<MainPage> {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        return this;
    }

    public void openAccountsManagement() {
        driver.findElement(By.id("accountsManagementLink")).click();
    }

    @Override
    protected void load() {
        driver.get("/home");
    }

    @Override
    protected void isLoaded()
            throws Error {
        try {
            driver.findElement(By.linkText("Main"));
        } catch (NoSuchElementException e) {
            fail("Cannot find Element Main");
        }
    }

    private void fail(String message) {
        System.out.println(message);
    }
}
