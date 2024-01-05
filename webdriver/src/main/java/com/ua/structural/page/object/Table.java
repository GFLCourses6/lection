package com.ua.structural.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Table {
    @FindBy(css = "tr")
    private List<WebElement> rows;

    public int getRowCount() {
        return rows.size();
    }
}
