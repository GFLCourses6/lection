package com.ua.followers.model;

import java.util.Objects;

public record Message(String content) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(content, message.content);
    }

    @Override
    public String toString() {
        return "'%s'\u001B[0m".formatted(content);
    }
}
