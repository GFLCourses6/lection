package com.ua.observer.publisher;

import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.subscriber.Subscriber;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers(String topic, Message message);

    void notifySubscribers(String topic, Event event);

    void eventOccurred();
}