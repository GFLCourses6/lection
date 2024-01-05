package com.ua.pool;

import com.ua.dto.model.dto.Login;
import com.ua.structural.pool.LoginPool;
import com.ua.structural.strategy.UserRegistrationStrategy;
import com.ua.structural.strategy.WebUserRegistrationStrategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.mock;

class LoginPoolTest {

    private final WebDriver driver = Mockito.mock(WebDriver.class);
    UserRegistrationStrategy strategy = new WebUserRegistrationStrategy(driver);

    private final LoginPool LOGIN_POOL = new LoginPool();
    private Login login;

    @BeforeEach
    public void init() {
        login = LOGIN_POOL.getAvailableLogin();
    }

    @AfterEach
    public void cleanup() {
        LOGIN_POOL.releaseLogin(login);
    }

//    @Test
    void userHasAbilityToChangeReadPreferences() {
        strategy.login(login.getLogin(), login.getPassword());
        strategy.goToReadPreferences();
        strategy.openMailbox(login);
    }
}