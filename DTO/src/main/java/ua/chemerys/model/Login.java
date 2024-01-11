package ua.chemerys.model;

import java.util.Objects;

//an example of best practice in creating a DTO

public class Login {

    private String username;
    private String password;
    private Long timestamp;

    //Empty constructor MUST BE for serialization and deserialization
    public Login() {

    }

    public Login(String username, String password, Long timestamp) {
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(username, login.username) &&
                Objects.equals(password, login.password) &&
                Objects.equals(timestamp, login.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, timestamp);
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
