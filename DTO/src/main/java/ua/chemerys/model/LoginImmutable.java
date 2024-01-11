package ua.chemerys.model;

public final class LoginImmutable {

    private final String username;
    private final String password;
    private final Long timestamp;

    public LoginImmutable(String username, String password, Long timestamp) {
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
