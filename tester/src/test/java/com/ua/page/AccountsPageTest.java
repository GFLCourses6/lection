package com.ua.page;

import com.ua.structural.page.AccountsPage;
import com.ua.structural.page.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AccountsPageTest {

    private WebDriver driver;
    private AccountsPage accountsPage;

    @BeforeEach
    public void setUp() {
//        driver = new FirefoxDriver();
        driver = mock(FirefoxDriver.class);
        accountsPage = new AccountsPage(driver);
        driver.get("http://the-internet.herokuapp.com");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void openAccountsPage() {
        PageFactory
                .initElements(driver, MainPage.class)
                .open()
                .openAccountsManagement();
    }

    void userNameSuggestionsChain() {
        accountsPage
                .typeFirstLetterOfName("j")
                .waitForSuggestions()
                .selectFirstSuggestedName();
        assertEquals("John", accountsPage.getUserName());
    }

    void userNameSuggestions() {
        accountsPage.typeFirstLetterOfName("j");
        accountsPage.waitForSuggestions();
        accountsPage.selectFirstSuggestedName();
        assertEquals("John", accountsPage.getUserName());
    }
}
