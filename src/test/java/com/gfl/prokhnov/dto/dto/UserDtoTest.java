package com.gfl.prokhnov.dto.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("User DTO Test")
class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    void init() {
        userDto = new UserDto();
    }

    @AfterEach
    void tearDown() {
        userDto = null;
    }

    @Test
    @DisplayName("Default constructor has all fields NULL")
    void testDefaultConstructor() {
        assertNull(userDto.getLogin());
        assertNull(userDto.getPassword());
        assertNull(userDto.getTimestamp());
    }

    @Test
    @DisplayName("The constructor of all arguments sets the correct fields")
    void testAllArgsConstructor() {
        userDto = new UserDto("Login", "Password", 1000L);
        assertEquals("Login", userDto.getLogin());
        assertEquals("Password", userDto.getPassword());
        assertEquals(1000L, userDto.getTimestamp());
    }

    @Test
    @DisplayName("Test Setters and Getters")
    void testSettersAndGetters() {
        userDto.setLogin("Login");
        userDto.setPassword("Password");
        userDto.setTimestamp(1000L);

        assertEquals("Login", userDto.getLogin());
        assertEquals("Password", userDto.getPassword());
        assertEquals(1000L, userDto.getTimestamp());

    }

    @Test
    @DisplayName("Test Equals and HashCode")
    void testEqualsAndHashCode() {
        UserDto userDto1 = new UserDto("Login", "Password", 1000L);
        UserDto userDto2 = new UserDto("Login", "Password", 1000L);

        assertEquals(userDto1, userDto2);
        assertEquals(userDto1.hashCode(), userDto2.hashCode());
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        assertEquals("UserDto{login='null', password='null', timestamp='null'}", userDto.toString());
    }


}