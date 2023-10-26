package com.classwork.pattern.dto.mapper;

import com.classwork.pattern.dto.model.dto.Login;
import com.classwork.pattern.dto.model.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    @Test
    public void testToLogin() {
        User user = new User();
        user.setName("Jack");
        user.setSurname("Sparrow");
        user.setTimestamp(10L);

        Login login = UserMapper.toLogin(user);

        assertEquals("Jack", login.getLogin());
        assertEquals("Sparrow", login.getPassword());
        assertEquals(user.getTimestamp(), login.getTimestamp());
    }

    @Test
    public void testToUser() {
        Login login = new Login();
        login.setLogin("William");
        login.setPassword("Turner");
        login.setTimestamp(10L);

        User user = UserMapper.toUser(login);

        assertEquals("William", user.getName());
        assertEquals("Turner", user.getSurname());
        assertEquals(login.getTimestamp(), user.getTimestamp());
    }
}