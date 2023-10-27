package com.gfl.dto;

import com.gfl.dto.model.dto.UserCredentials;
import com.gfl.dto.model.entity.User;
import com.gfl.dto.model.mapper.UserMapper;

import java.time.LocalDate;

public class AppDto {

    public static void main(String[] args) {
        AppDto app = new AppDto();
        app.run();
    }

    public void run() {
        var credentials = new UserCredentials("gfl@gmail.com", "12345", 100L);
        var user = UserMapper.userCredentialsToUser(credentials);
        System.out.println(user);

        var user2 = new User("email@gmail.com", "12345", "first",
                "last", LocalDate.now(), 100L);
        var credentials2 = UserMapper.userToUserCredentials(user2);
        System.out.println(credentials2);
    }
}
