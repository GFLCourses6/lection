package com.ua.structural.strategy;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.dto.Role;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Timestamp;
import java.util.List;

public class WebUserRegistrationStrategy
        implements UserRegistrationStrategy {

    private final WebDriver driver;

    public WebUserRegistrationStrategy(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(Login user) {
        enter(user.getLogin(), into("loginName"));
        enter(user.getPassword(), into("password"));
        chooseRoles(user.getRoles(), user.isPaid());
    }

    @Override
    public Login register(
            String name,
            String password) {
        openRegistrationPage();
        enter(name, into("locator: #name"));
        enter(password, into("locator: #password"));
        enter(password, into("locator: #confirm_password"));
        click("locator: #register");
        return new Login(getIdFromUrl(),
                         name,
                         password,
                         new Timestamp(System.currentTimeMillis()).getTime());
    }

    @Override
    public Login login(
            String name,
            String password) {
        openLoginPage();
        enter(name, into("locator: #name"));
        enter(password, into("locator: #password"));
        enter(password, into("locator: #confirm_password"));
        click("locator: #register");
        return new Login(name, password);
    }

    private void openLoginPage() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    private void openRegistrationPage() {
        driver.get("http://the-internet.herokuapp.com/signup");
    }

    private void enter(
            String text,
            By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private String getIdFromUrl() {
        String currentUrl = driver.getCurrentUrl();
        String[] parts = currentUrl.split("/");
        return parts[parts.length - 1];
    }

    private void click(String locatorString) {
        driver.findElement(into(locatorString)).click();
    }

    private By into(String locatorString) {
        String[] parts = locatorString.split(" ");
        String locatorType = parts[1];
        String locatorValue = parts[2];
        return switch (locatorType) {
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            default -> throw new IllegalArgumentException(
                    "Unsupported locator type: " + locatorType);
        };
    }

    private void chooseRoles(
            List<Role> roles,
            boolean paid) {
        if (roles != null && !roles.isEmpty()) {
            roles.forEach(this::selectRole);
        }
        if (paid) {
            selectPaidOption();
        }
    }

    private void selectRole(Role role) {
        new Select(driver.findElement(By.id("rolesDropdown")))
                .selectByVisibleText(role.getDescription());
    }

    private void selectPaidOption() {
        driver.findElement(By.id("paidCheckbox")).click();
    }

    public void openMailbox(Login login) {
        driver.findElement(By.id("mailboxLink")).click();
    }

    @Override
    public void goToReadPreferences() {
        driver.findElement(By.id("readPreferencesLink")).click();
    }
}
