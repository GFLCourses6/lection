package vladproduction.com;

public class User {

    private final String login;
    private final String password;
    private final Long timestamp;

    public User(Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.timestamp = builder.timestamp;
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
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class Builder{
        private  String login;
        private  String password;
        private  Long timestamp;

        public Builder(){}

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
