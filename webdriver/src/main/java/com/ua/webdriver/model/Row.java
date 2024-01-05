package com.ua.webdriver.model;

import java.util.Map;

public class Row {
    private String action;
    private String webSite;
    private String email;
    private String due;
    private String firstName;
    private String lastName;

    public Row(Map<String, String> rowData) {
        this.action = rowData.get("Action");
        this.webSite = rowData.get("Web Site");
        this.email = rowData.get("Email");
        this.due = rowData.get("Due");
        this.firstName = rowData.get("First Name");
        this.lastName = rowData.get("Last Name");
    }

    @Override
    public String toString() {
        return ("Row{Action='%s', WebSite='%s', Email='%s', Due='%s', FirstName='%s', LastName='%s'}").formatted(
                action,
                webSite,
                email,
                due,
                firstName,
                lastName);
    }
}
