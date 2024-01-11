package ua.chemerys.model;

public class LoginWithMultiplyResponsibilities {

    private String username;
    private String password;
    private Long timestamp;

    //Bad practice
    //Getters and setters MUST be just getters and setters
    //KISS

    //Do not forget about constructors
    public String getUsername() {
        return "Mr. and Mrs: " + username;
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
}
