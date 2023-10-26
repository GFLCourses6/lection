package com.classwork.pattern.dto.dto;

import com.classwork.pattern.dto.model.dto.LoginRecord;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LoginRecordTest {

    private LoginRecord login;

    @Before
    public void setUp() {
        login = new LoginRecord("William", "Turner", 10L);
    }

    @Test
    public void testGetLogin() {
        assertEquals("William", login.getLogin());
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
        LoginRecord will = new LoginRecord("William", "Turner", 10L);
        LoginRecord jack = new LoginRecord("Jack", "Sparrow", 20L);

        assertEquals(login, will);
        assertNotEquals(login, jack);
    }

    @Test
    public void testNotNullEquals() {
        assertNotEquals(login, null);
    }

    @Test
    public void testHashCode() {
        LoginRecord will = new LoginRecord("William", "Turner", 10L);
        LoginRecord jack = new LoginRecord("Jack", "Sparrow", 20L);

        assertEquals(login.hashCode(), will.hashCode());
        assertNotEquals(login.hashCode(), jack.hashCode());
    }
}