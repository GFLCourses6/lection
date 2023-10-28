package com.gfl.prokhnov.dto;

import com.gfl.prokhnov.dto.dto.UserDto;
import com.gfl.prokhnov.dto.entity.User;
import com.gfl.prokhnov.dto.mapper.UserMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DtoApp {

    private static final Logger LOGGER = LogManager.getLogger(DtoApp.class.getName());

    public static void main(String[] args) {
        DtoApp appDto = new DtoApp();
        appDto.run();
    }

    private void run(){
        User user = new User(1,"userLogin","userPassword","user@gmail.com","userFirstName", "userLastName", 30);
        LOGGER.info(user);
        UserDto userDtoFromUser = UserMapper.userToUserDto(user);
        LOGGER.info(userDtoFromUser);

        UserDto userDto = new UserDto("userDtoLogin", "userDtoPassword", "userDtoEmail");
        LOGGER.info(userDto);
        User userFromUserDto = UserMapper.userDtoToUser(userDto);
        LOGGER.info(userFromUserDto);
    }
}
