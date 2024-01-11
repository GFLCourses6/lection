package com.ua.profile.model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login)
                && Objects.equals(date, user.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, date);
    }
}
