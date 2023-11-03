package com.classwork.pattern.dto.dto;

import com.classwork.pattern.dto.model.dto.LoginRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class LoginRecordTest {

    private LoginRecord login;

    @BeforeEach
    void setUp() {
        login = new LoginRecord("William", "Turner", 10L);
    }

    @Test
    void testGetLogin() {
        assertEquals("William", login.getLogin());
    }

    @Test
    void testGetPassword() {
        assertEquals("Turner", login.getPassword());
    }

    @Test
    void testGetTimestamp() {
        assertEquals(10L, (long) login.getTimestamp());
    }

    @Test
    void testToString() {
        String expectedToString = "{login: William, password: Turner, timestamp: 10}";
        assertEquals(expectedToString, login.toString());
    }

    @Test
    void testEquals() {
        LoginRecord will = new LoginRecord("William", "Turner", 10L);
        LoginRecord jack = new LoginRecord("Jack", "Sparrow", 20L);

        assertEquals(login, will);
        assertNotEquals(login, jack);
    }

    @Test
    void testNotNullEquals() {
        assertNotEquals(login, null);
    }

    @Test
    void testHashCode() {
        LoginRecord will = new LoginRecord("William", "Turner", 10L);
        LoginRecord jack = new LoginRecord("Jack", "Sparrow", 20L);

        assertEquals(login.hashCode(), will.hashCode());
        assertNotEquals(login.hashCode(), jack.hashCode());
    }
}