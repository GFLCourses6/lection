package com.gfl.prokhnov.dto.mapper;

import com.gfl.prokhnov.dto.dto.UserDto;
import com.gfl.prokhnov.dto.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Mapper Test")
class UserMapperTest {

    private User user;
    private UserDto userDto;

    @BeforeEach
    void init() {
        user = new User(1L, "Login", "Password",
                1000L, "Email", "FirstName",
                "LastName", 18);
        userDto = new UserDto("Login", "Password", 1000L);

    }

    @AfterEach
    void tearDown() {
        user = null;
        userDto = null;
    }

    @Test
    @DisplayName("Test map User to UserDto ")
    void testUserToUserDto() {
        assertEquals(userDto, UserMapper.userToUserDto(user));
    }

    @Test
    @DisplayName("Test map UserDto to User ")
    void testUserDtoToUser() {
        User expectedUser = new User();
        expectedUser.setLogin("Login");
        expectedUser.setPassword("Password");
        expectedUser.setTimestamp(1000L);
        assertEquals(expectedUser, UserMapper.userDtoToUser(userDto));
    }
}