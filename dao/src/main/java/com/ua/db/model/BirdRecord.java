package com.ua.db.model;

public record BirdRecord(int id, String name, String description) {

    @Override
    public String toString() {
        return "Bird{id=%d, name='%s', description='%s'}"
                .formatted(id, name, description);
    }
}
