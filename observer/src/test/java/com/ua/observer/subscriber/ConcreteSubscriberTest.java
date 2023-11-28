package com.ua.observer.subscriber;

import com.ua.observer.broker.Broker;
import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.broker.QueueBroker;
import com.ua.observer.publisher.ProxyPublisher;
import com.ua.observer.publisher.Publisher;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcreteSubscriberTest {

    @Test
    void testNotifySubscribersAndEventOccurred() {
        Broker broker = new QueueBroker();

        Publisher news = new ProxyPublisher(broker, "news");
        Publisher sport = new ProxyPublisher(broker, "sport");
        Subscriber a = new ConcreteSubscriber("A");
        Subscriber b = new ConcreteSubscriber("B");

        news.addSubscriber(a);
        sport.addSubscriber(b);

        Message message = new Message("new Event");
        Event event = new Event(message);
        broker.publishEvent("topic", message);
        Queue<Event> eventQueue = broker.getEventQueue();
        assertEquals(1, eventQueue.size());
        assertTrue(eventQueue.contains(event));

        news.notifySubscribers("news", event);
        news.eventOccurred();
        eventQueue = broker.getEventQueue();
        assertEquals(2, eventQueue.size());
    }
}