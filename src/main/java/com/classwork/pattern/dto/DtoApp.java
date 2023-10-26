package com.classwork.pattern.dto;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.dto.model.dto.LoginRecord;
import com.classwork.pattern.dto.model.entity.Ship;
import com.classwork.pattern.dto.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.classwork.pattern.dto.mapper.UserMapper.toLogin;
import static com.classwork.pattern.dto.mapper.UserMapper.toUser;

class DtoApp {
    private static final Logger LOGGER = LogManager.getLogger(DtoApp.class);

    public static void main(String[] args) {
        User user = new User("Jack", "Sparrow");
        Ship ship = new Ship("Black Pearl");
        LoginRecord loginRecord = new LoginRecord("Jack", "Sparrow", 100L);
        user.addShip(ship);

        Login login = toLogin(user);
        User jack = toUser(login);

        LOGGER.info(loginRecord);
        LOGGER.info(jack);
    }
}
