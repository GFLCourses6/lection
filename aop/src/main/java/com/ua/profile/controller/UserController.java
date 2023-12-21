package com.ua.profile.controller;

import com.ua.profile.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "api")
public class UserController {

    @GetMapping(value = "/user", produces = "Application/json")
    public User getUser() {
        return new User("Paul", LocalDateTime.now());
    }
}
