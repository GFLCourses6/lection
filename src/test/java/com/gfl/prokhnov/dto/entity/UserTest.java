package com.gfl.prokhnov.dto.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("User Entity Test")
class UserTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    @DisplayName("Default constructor has all fields NULL")
    void testDefaultConstructor() {
        assertNull(user.getId());
        assertNull(user.getLogin());
        assertNull(user.getPassword());
        assertNull(user.getTimestamp());
        assertNull(user.getEmail());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getAge());
    }

    @Test
    @DisplayName("The constructor of all arguments sets the correct fields")
    void testAllArgsConstructor() {
        User user1 = new User(1L, "Login", "Password",
                1000L, "Email", "FirstName",
                "LastName", 18);
        assertEquals(1L, user1.getId());
        assertEquals("Login", user1.getLogin());
        assertEquals("Password", user1.getPassword());
        assertEquals(1000L, user1.getTimestamp());
        assertEquals("Email", user1.getEmail());
        assertEquals("FirstName", user1.getFirstName());
        assertEquals("LastName", user1.getLastName());
        assertEquals(18, user1.getAge());
    }

    @Test
    @DisplayName("Test Setters and Getters")
    void testSettersAndGetters() {

        user.setId(1L);
        user.setLogin("Login");
        user.setPassword("Password");
        user.setTimestamp(1000L);
        user.setEmail("Email");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setAge(18);

        assertEquals(1L, user.getId());
        assertEquals("Login", user.getLogin());
        assertEquals("Password", user.getPassword());
        assertEquals(1000L, user.getTimestamp());
        assertEquals("Email", user.getEmail());
        assertEquals("FirstName", user.getFirstName());
        assertEquals("LastName", user.getLastName());
        assertEquals(18, user.getAge());
    }

    @Test
    @DisplayName("Test Equals and HashCode")
    void testEqualsAndHashCode() {
        User user1 = new User(1L, "Login", "Password", 1000L, "Email", "FirstName", "LastName", 18);
        User user2 = new User(1L, "Login", "Password", 1000L, "Email", "FirstName", "LastName", 18);

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        assertEquals("User{id=null, login='null', password='null', timestamp=null, email='null', firstName='null', lastName='null', age=null}", user.toString());
    }


}