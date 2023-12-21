package com.ua.structural.strategy;

import com.ua.dto.model.dto.Login;

public class RestUserRegistrationStrategy
        implements UserRegistrationStrategy {
    @Override
    public Login register(
            String name,
            String password) {
        //        return put("/api/user")
        //                .withBody(toJson(new Login(name, password)))
        //                .toObject(Login.class);
        return new Login(name, password);
    }

    @Override
    public Login login(
            String name,
            String password) {
        return new Login(name, password);
    }

    @Override
    public void openMailbox(Login login) {

    }

    @Override
    public void goToReadPreferences() {

    }
}
