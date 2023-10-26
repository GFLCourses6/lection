package com.classwork.pattern.dto.dto;

import com.classwork.pattern.dto.model.dto.Login;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.setLogin("William");
        login.setPassword("Turner");
        login.setTimestamp(10L);
    }

    @Test
    public void testGetLogin() {
        assertEquals("William", login.getLogin());
    }

    @Test
    public void testSetLogin() {
        login.setLogin("NewLogin");
        assertEquals("NewLogin", login.getLogin());
    }

    @Test
    public void testGetPassword() {
        assertEquals("Turner", login.getPassword());
    }

    @Test
    public void testGetTimestamp() {
        assertEquals(10L, (long) login.getTimestamp());
    }

    @Test
    public void testToString() {
        String expectedToString = "{login: William, password: Turner, timestamp: 10}";
        assertEquals(expectedToString, login.toString());
    }

    @Test
    public void testEquals() {
        Login will = new Login("William", "Turner", 10L);

        assertEquals(login, will);
    }

    @Test
    public void testNotEquals() {
        Login jack = new Login();
        jack.setLogin("Jack");
        jack.setPassword("Sparrow");
        jack.setTimestamp(20L);

        assertNotEquals(login, jack);
    }

    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals(null, login);
    }

    @Test
    public void testEqualsWithSameObject() {
        assertEquals(login, login);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals(login, login.toString());
    }

    @Test
    public void testHashCode() {
        Login will = new Login();
        will.setLogin("William");
        will.setPassword("Turner");
        will.setTimestamp(10L);

        Login jack = new Login();
        jack.setLogin("Jack");
        jack.setPassword("Sparrow");
        jack.setTimestamp(20L);

        assertEquals(login.hashCode(), will.hashCode());
        assertNotEquals(login.hashCode(), jack.hashCode());
    }
}