package com.gfl.dto;

import com.gfl.dto.model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("user", "password", 10L);
        System.out.println(user);
    }
}
