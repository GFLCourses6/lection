package com.ua.observer.broker;

import com.ua.observer.publisher.Publisher;
import com.ua.observer.subscriber.Subscriber;

import java.util.Queue;

public interface Broker {

    void addPublisher(
            String topic,
            Publisher publisher);

    void removePublisher(String topic);

    void subscribe(
            String topic,
            Subscriber subscriber);

    void unsubscribe(
            String topic,
            Subscriber subscriber);

    void notifySubscribers(
            String topic,
            Event event);

    void notifySubscribers(
            String topic,
            Message message);

    void publishEvent(
            String topic,
            Message message);

    Queue<Event> getEventQueue();
}
