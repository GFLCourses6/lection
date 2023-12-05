package com.gfl.prokhnov.example.patterns.dto.mapper;

import com.gfl.prokhnov.example.patterns.dto.dto.UserDto;
import com.gfl.prokhnov.example.patterns.dto.entity.User;

public class UserMapper {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setTimestamp(user.getTimestamp());
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setTimestamp(userDto.getTimestamp());
        return user;
    }
}
