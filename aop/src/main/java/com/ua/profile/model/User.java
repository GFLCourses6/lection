package com.ua.profile.model;

import java.time.LocalDateTime;

public class User {

    private String login;
    private LocalDateTime date;

    public User(
            String login,
            LocalDateTime date) {
        this.login = login;
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
