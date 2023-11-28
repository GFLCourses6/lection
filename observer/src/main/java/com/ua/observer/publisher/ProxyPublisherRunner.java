package com.ua.observer.publisher;

import com.ua.observer.broker.Broker;
import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.subscriber.Subscriber;

public class ProxyPublisherRunner
        implements Publisher {
    private final Broker broker;
    private final String topic;

    public ProxyPublisherRunner(
            Broker broker,
            String topic) {
        this.broker = broker;
        this.topic = topic;
    }

    public void addSubscriber(
            Subscriber subscriber,
            Runnable callable) {
        broker.subscribe(topic, subscriber);
        if (callable != null) {
            callable.run();
        }
    }

    public void removeSubscriber(
            Subscriber subscriber,
            Runnable callable) {
        broker.unsubscribe(topic, subscriber);
        if (callable != null) {
            callable.run();
        }
    }

    public void notifySubscribers(
            String topic,
            Message message,
            Runnable callable) {
        broker.notifySubscribers(topic, message);
        if (callable != null) {
            callable.run();
        }
    }

    public void notifySubscribers(
            String topic,
            Event event,
            Runnable callable) {
        broker.notifySubscribers(topic, event);
        if (callable != null) {
            callable.run();
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        addSubscriber(subscriber, null);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        removeSubscriber(subscriber, null);
    }

    @Override
    public void notifySubscribers(
            String topic,
            Message message) {
        notifySubscribers(topic, message, null);
    }

    @Override
    public void notifySubscribers(
            String topic,
            Event event) {
        notifySubscribers(topic, event, null);
    }

    @Override
    public void eventOccurred() {
        Event event = new Event(new Message("Something new happened!"));
        notifySubscribers("new", event);
    }
}
