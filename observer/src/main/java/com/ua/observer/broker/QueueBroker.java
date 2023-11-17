package com.ua.observer.broker;

import com.ua.observer.publisher.Publisher;
import com.ua.observer.subscriber.Subscriber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBroker
        implements Broker {

    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();
    private final Map<String, Publisher> publishers = new HashMap<>();
    private final Queue<Event> eventQueue = new LinkedBlockingDeque<>();

    @Override
    public void addPublisher(
            String topic,
            Publisher publisher) {
        publishers.put(topic, publisher);
    }

    @Override
    public void removePublisher(String topic) {
        publishers.remove(topic);
    }

    @Override
    public void subscribe(
            String topic,
            Subscriber subscriber) {
        subscribers
                .computeIfAbsent(topic, s -> new LinkedList<>())
                .add(subscriber);
    }

    @Override
    public void unsubscribe(
            String topic,
            Subscriber subscriber) {
        subscribers.getOrDefault(topic, new LinkedList<>()).remove(subscriber);
    }

    @Override
    public void notifySubscribers(
            String topic,
            Event event) {
        for (Subscriber subscriber : subscribers.getOrDefault(topic,
                new LinkedList<>())) {
            subscriber.update(event);
        }
    }

    @Override
    public void notifySubscribers(
            String topic,
            Message message) {
        subscribers
                .getOrDefault(topic, new LinkedList<>())
                .forEach(subscriber -> subscriber.receiveMessage(message));
    }

    @Override
    public void publishEvent(
            String topic,
            Message message) {
        eventQueue.offer(new Event(message));
        notifySubscribers(topic, message);
    }
}
