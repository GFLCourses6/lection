package com.gfl.dto.model.dto;

import java.util.Objects;

public class UserCredentials {

    private String login;
    private String password;
    private Long timestamp;

    public UserCredentials() {
    }

    public UserCredentials(String login, String password, Long timestamp) {
        this.login = login;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCredentials that)) return false;
        return Objects.equals(login, that.login)
                && Objects.equals(password, that.password)
                && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("UserCredentials{")
                .append("login='").append(login).append('\'')
                .append(", password='").append(password).append('\'')
                .append(", timestamp=").append(timestamp)
                .append('}').toString();
    }
}
