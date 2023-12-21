package com.ua.db.service;

public record Bird(int id, String name, String description) {

    @Override
    public String toString() {
        return "Bird{id=%d, name='%s', description='%s'}"
                .formatted(id, name, description);
    }
}
