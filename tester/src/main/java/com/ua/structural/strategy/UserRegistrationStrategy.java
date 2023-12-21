package com.ua.structural.strategy;

import com.ua.dto.model.dto.Login;

public interface UserRegistrationStrategy {

    Login register(String name, String password);

    Login login(String name, String password);

    void openMailbox(Login login);

    void goToReadPreferences();
}
