package com.gfl.prokhnov.example.patterns.dto;

import com.gfl.prokhnov.example.patterns.dto.dto.UserDto;
import com.gfl.prokhnov.example.patterns.dto.entity.User;
import com.gfl.prokhnov.example.patterns.dto.mapper.UserMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DtoApp {

    private static final Logger LOGGER = LogManager.getLogger(DtoApp.class.getName());

    public static void main(String[] args) {
        DtoApp appDto = new DtoApp();
        appDto.run();
    }

    private void run(){
        User user = new User(1L,"userLogin","userPassword", 1000L,"user@gmail.com","userFirstName", "userLastName", 30);
        LOGGER.info(user);
        UserDto userDtoFromUser = UserMapper.userToUserDto(user);
        LOGGER.info(userDtoFromUser);

        UserDto userDto = new UserDto("userDtoLogin", "userDtoPassword", 10L);
        LOGGER.info(userDto);
        User userFromUserDto = UserMapper.userDtoToUser(userDto);
        LOGGER.info(userFromUserDto);
    }
}
