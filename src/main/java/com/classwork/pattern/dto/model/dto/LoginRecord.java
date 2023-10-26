package com.classwork.pattern.dto.model.dto;

import java.util.Objects;

public final class LoginRecord {
    private final String login;
    private final String password;
    private final Long timestamp;

    public LoginRecord(String login, String password, Long timestamp) {
        this.login = login;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("{login: %s, password: %s, timestamp: %d}",
                             login, password, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginRecord that = (LoginRecord) o;
        return Objects.equals(login, that.login)
                && Objects.equals(password, that.password)
                && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, timestamp);
    }
}
