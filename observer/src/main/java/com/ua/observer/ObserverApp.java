package com.ua.observer;

import com.ua.observer.broker.Broker;
import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.broker.QueueBroker;
import com.ua.observer.publisher.ProxyPublisher;
import com.ua.observer.publisher.Publisher;
import com.ua.observer.subscriber.ConcreteSubscriber;
import com.ua.observer.subscriber.Subscriber;

public class ObserverApp {
    public static void main(String[] args) {
        Broker broker = new QueueBroker();
        Publisher news = new ProxyPublisher(broker, "news");
        Publisher sport = new ProxyPublisher(broker, "sport");

        Subscriber a = new ConcreteSubscriber("A");
        Subscriber b = new ConcreteSubscriber("B");

        news.addSubscriber(a);
        sport.addSubscriber(b);

        Event event = new Event(new Message("new Event"));
        news.notifySubscribers("news", event);

        news.eventOccurred();
        sport.eventOccurred();
    }
}
