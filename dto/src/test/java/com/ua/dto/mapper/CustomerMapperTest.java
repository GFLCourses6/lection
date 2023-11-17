package com.ua.dto.mapper;

import com.ua.dto.model.dto.Login;
import com.ua.dto.model.entity.Customer;
import com.ua.dto.model.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {

    @Test
    void testToLogin() {
        Customer user = new Customer();
        user.setName("Jack");
        user.setSurname("Sparrow");
        user.setTimestamp(10L);

        Login login = CustomerMapper.toLogin(user);

        assertEquals("Jack", login.getLogin());
        assertEquals("Sparrow", login.getPassword());
        assertEquals(user.getTimestamp(), login.getTimestamp());
    }

    @Test
    void testToUser() {
        Login login = new Login();
        login.setLogin("William");
        login.setPassword("Turner");
        login.setTimestamp(10L);

        Customer user = CustomerMapper.toUser(login);

        assertEquals("William", user.getName());
        assertEquals("Turner", user.getSurname());
        assertEquals(login.getTimestamp(), user.getTimestamp());
    }
}