package com.gfl.pubsub;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class Message {

    private final LocalDate createdAte;
    private final String textMessage;

    public Message(String textMessage) {
        createdAte = LocalDate.now();
        this.textMessage = textMessage;
    }

    @Override
    public String toString() {
        return "Message{" +
                "createdAte=" + createdAte +
                ", textMessage='" + textMessage + '\'' +
                '}';
    }
}
