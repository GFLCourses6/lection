package com.ua.observer.subscriber;

import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;

public class ConcreteSubscriber
        implements Subscriber {
    private final String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Event event) {
        System.out.printf("Subscriber %s received event: %s%n",
                name, event.message());
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.printf("Subscriber %s received message: %s%n",
                name, message.content());
    }
}
