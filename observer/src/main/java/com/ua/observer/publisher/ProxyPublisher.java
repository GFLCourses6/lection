package com.ua.observer.publisher;

import com.ua.observer.broker.Broker;
import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.subscriber.Subscriber;

public class ProxyPublisher
        implements Publisher {
    private final Broker broker;
    private final String topic;

    public ProxyPublisher(
            Broker broker,
            String topic) {
        this.broker = broker;
        this.topic = topic;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        broker.subscribe(topic, subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        broker.unsubscribe(topic, subscriber);
    }

    @Override
    public void notifySubscribers(
            String topic,
            Message message) {
        broker.notifySubscribers(topic, message);
    }

    @Override
    public void notifySubscribers(
            String topic,
            Event event) {
        broker.notifySubscribers(topic, event);
    }

    @Override
    public void eventOccurred() {
        Event event = new Event(
                new Message("Something new happened!"));
        notifySubscribers("new", event);
    }
}
