package com.ua.observer.subscriber;

import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;

public interface Subscriber {
    void update(Event event);

    void receiveMessage(Message message);
}
