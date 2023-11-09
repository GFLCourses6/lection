package com.classwork.pattern.dto.model.dto;

import java.util.Objects;

public class Login {
    private String loginName;
    private String password;
    private Long timestamp;

    public Login() {
    }

    public Login(
            String loginName,
            String password,
            Long timestamp) {
        this.loginName = loginName;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getLogin() {
        return loginName;
    }

    public void setLogin(String login) {
        this.loginName = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("{login: %s, password: %s, timestamp: %d}",
                loginName, password, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Login that = (Login) o;
        return Objects.equals(loginName, that.loginName) && Objects.equals(
                password, that.password) && Objects.equals(timestamp,
                that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName, password, timestamp);
    }
}
