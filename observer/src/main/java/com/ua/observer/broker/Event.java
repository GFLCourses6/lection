package com.ua.observer.broker;

import java.util.Objects;

public record Event(Message message) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(message, event.message);
    }

    @Override
    public String toString() {
        return "Event{message='%s'}".formatted(message);
    }
}
