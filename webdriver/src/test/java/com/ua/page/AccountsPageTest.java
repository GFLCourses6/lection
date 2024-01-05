package com.ua.page;

import com.ua.structural.page.AccountsPage;
import com.ua.structural.page.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountsPageTest {

    @BeforeEach
    public void openAccountsPage() {
        PageFactory
                .initElements(webDriver, MainPage.class)
                .open()
                .openAccountsManagement();
    }

    private WebDriver driver;
    private WebDriver webDriver;
    private AccountsPage accountsPage;

    @BeforeEach
    public void setUp() {
        accountsPage = new AccountsPage(driver);
        driver.get("http://the-internet.herokuapp.com");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    void userNameSuggestionsChain() {
        accountsPage
                .typeFirstLetterOfName("j")
                .waitForSuggestions()
                .selectFirstSuggestedName();
        Assertions.assertEquals("John", accountsPage.getUserName());
    }

    void userNameSuggestions() {
        accountsPage.typeFirstLetterOfName("j");
        accountsPage.waitForSuggestions();
        accountsPage.selectFirstSuggestedName();
        Assertions.assertEquals("John", accountsPage.getUserName());
    }
}
