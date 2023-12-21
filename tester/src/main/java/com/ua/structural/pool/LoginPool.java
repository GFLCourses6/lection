package com.ua.structural.pool;

import com.ua.dto.model.dto.Login;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LoginPool {
    private final BlockingQueue<Login> loginPoolQueue =
            new LinkedBlockingQueue<>();

    public Login getAvailableLogin() {
        try {
            return loginPoolQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error getting login from the pool", e);
        }
    }

    public boolean releaseLogin(Login login) {
        return loginPoolQueue.offer(login);
    }
}
