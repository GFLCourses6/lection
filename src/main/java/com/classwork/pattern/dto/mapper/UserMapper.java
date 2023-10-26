package com.classwork.pattern.dto.mapper;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.dto.model.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static Login toLogin(User user) {
        Login login = new Login();
        login.setLogin(user.getName());
        login.setPassword(user.getSurname());
        login.setTimestamp(user.getTimestamp());
        return login;
    }

    public static User toUser(Login login) {
        User user = new User();
        user.setName(login.getLogin());
        user.setSurname(login.getPassword());
        user.setTimestamp(login.getTimestamp());
        return user;
    }
}
