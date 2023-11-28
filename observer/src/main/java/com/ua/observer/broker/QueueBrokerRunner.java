package com.ua.observer.broker;

import com.ua.observer.publisher.Publisher;
import com.ua.observer.subscriber.Subscriber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBrokerRunner
        implements Broker {
    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();
    private final Map<String, Publisher> publishers = new HashMap<>();
    private final Queue<Event> eventQueue = new LinkedBlockingDeque<>();

    @Override
    public void addPublisher(
            String topic,
            Publisher publisher) {
        addPublisher(topic, publisher, null);
    }

    public void addPublisher(
            String topic,
            Publisher publisher,
            Runnable callback) {
        publishers.put(topic, publisher);
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void removePublisher(String topic) {
        removePublisher(topic, null);
    }

    public void removePublisher(
            String topic,
            Runnable callback) {
        publishers.remove(topic);
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void subscribe(
            String topic,
            Subscriber subscriber) {
        subscribe(topic, subscriber, null);
    }

    public void subscribe(
            String topic,
            Subscriber subscriber,
            Runnable callback) {
        subscribers.computeIfAbsent(topic, string -> new LinkedList<>())
                   .add(subscriber);
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void unsubscribe(
            String topic,
            Subscriber subscriber) {
        unsubscribe(topic, subscriber, null);
    }

    public void unsubscribe(
            String topic,
            Subscriber subscriber,
            Runnable callback) {
        subscribers.getOrDefault(topic, new LinkedList<>())
                   .remove(subscriber);
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void notifySubscribers(
            String topic,
            Event event) {
        notifySubscribers(topic, event, null);
    }

    public void notifySubscribers(
            String topic,
            Event event,
            Runnable callback) {
        eventQueue.offer(event);
        for (Subscriber subscriber : subscribers
                .getOrDefault(topic, new LinkedList<>())) {
            subscriber.update(eventQueue.poll());
        }
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void notifySubscribers(
            String topic,
            Message message) {
        notifySubscribers(topic, message, null);
    }

    public void notifySubscribers(
            String topic,
            Message message, Runnable callback) {
        subscribers.getOrDefault(topic, new LinkedList<>())
                   .forEach(subscriber -> subscriber
                           .receiveMessage(message));
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public void publishEvent(
            String topic,
            Message message) {
        publishEvent(topic, message, null);
    }

    public void publishEvent(
            String topic,
            Message message,
            Runnable callback) {
                eventQueue.offer(new Event(message));
                notifySubscribers(topic, eventQueue.poll());
        if (callback != null) {
            callback.run();
        }
    }

    public Map<String, List<Subscriber>> getSubscribers() {
        return subscribers;
    }

    public Map<String, Publisher> getPublishers() {
        return publishers;
    }

    public Queue<Event> getEventQueue() {
        return eventQueue;
    }
}
