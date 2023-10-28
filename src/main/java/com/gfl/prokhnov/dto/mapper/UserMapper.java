package com.gfl.prokhnov.dto.mapper;

import com.gfl.prokhnov.dto.dto.UserDto;
import com.gfl.prokhnov.dto.entity.User;

public class UserMapper {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
