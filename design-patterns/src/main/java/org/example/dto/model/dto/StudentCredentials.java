package org.example.dto.model.dto;

import java.util.Objects;

public class StudentCredentials {
    private String name;
    private String surname;
    private String login;
    private String password;

    StudentCredentials(){
    }

    public StudentCredentials(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCredentials that = (StudentCredentials) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("StudentCredentials{")
                .append("name=").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", login=").append(login)
                .append(", password=").append(password)
                .append('}').toString();
    }
}
