package com.ua.structural.page;

import com.ua.structural.page.object.Form;
import com.ua.structural.page.object.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IdealAccountsPage
        extends AbstractPage {
    private Form accountForm;
    @FindBy(css = "table")
    private Table accounts;

    public IdealAccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AbstractPage waitForSuggestions() {
        return null;
    }

    @Override
    public void selectFirstSuggestedName() {

    }

    public int getRegisteredUsersCount() {
        return accounts.getRowCount();
    }
}
