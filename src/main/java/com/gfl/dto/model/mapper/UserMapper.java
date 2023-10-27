package com.gfl.dto.model.mapper;

import com.gfl.dto.model.dto.UserCredentials;
import com.gfl.dto.model.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserCredentials userToUserCredentials(User user) {
        UserCredentials credentials = new UserCredentials();

        credentials.setLogin(user.getEmail());
        credentials.setPassword(user.getPassword());
        credentials.setTimestamp(user.getTimestamp());

        return credentials;
    }

    public static User userCredentialsToUser(UserCredentials userCredentials) {
        User user = new User();

        user.setEmail(userCredentials.getLogin());
        user.setPassword(userCredentials.getPassword());
        user.setTimestamp(userCredentials.getTimestamp());

        return user;
    }
}
