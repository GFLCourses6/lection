package com.ua.observer.publisher;

import com.ua.observer.broker.Broker;
import com.ua.observer.broker.Event;
import com.ua.observer.broker.Message;
import com.ua.observer.subscriber.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProxyPublisherRunnerTest {

    private Event event;
    private String topic;
    private Broker broker;
    private Message message;
    private Runnable callback;
    private Subscriber subscriber;
    private ProxyPublisherRunner proxyPublisherRunner;
    private ProxyPublisher proxyPublisher;

    @BeforeEach
    void setUp() {
        topic = "test";
        event = mock(Event.class);
        broker = mock(Broker.class);
        message = mock(Message.class);
        callback = mock(Runnable.class);
        subscriber = mock(Subscriber.class);
        proxyPublisher = new ProxyPublisher(broker, topic);
        proxyPublisherRunner = new ProxyPublisherRunner(broker, topic);
    }

    @Test
    void testAddSubscriberWithCallback() {
        proxyPublisherRunner.addSubscriber(subscriber, callback);
        verify(broker, times(1)).subscribe(topic, subscriber);
        verify(callback, times(1)).run();
    }

    @Test
    void testAddSubscriberWithoutCallback() {
        proxyPublisher.addSubscriber(subscriber);
        verify(broker, times(1)).subscribe(topic, subscriber);
        verify(callback, never()).run();
    }

    @Test
    void testRemoveSubscriberWithCallback() {
        proxyPublisherRunner.removeSubscriber(subscriber, callback);
        verify(broker, times(1)).unsubscribe(topic, subscriber);
        verify(callback, times(1)).run();
    }

    @Test
    void testRemoveSubscriberWithoutCallback() {
        proxyPublisherRunner.removeSubscriber(subscriber, null);
        verify(broker, times(1)).unsubscribe(topic, subscriber);
        verify(callback, never()).run();
    }

    @Test
    void testNotifySubscribersWithMessageWithCallback() {
        proxyPublisherRunner.notifySubscribers(topic, message, callback);
        verify(broker, times(1)).notifySubscribers(topic, message);
        verify(callback, times(1)).run();
    }

    @Test
    void testNotifySubscribersWithMessageWithoutCallback() {
        proxyPublisherRunner.notifySubscribers(topic, message, null);
        verify(broker, times(1)).notifySubscribers(topic, message);
        proxyPublisher.notifySubscribers(topic, message);
        verify(callback, never()).run();
    }

    @Test
    void testNotifySubscribersWithEventWithCallback() {
        proxyPublisherRunner.notifySubscribers(topic, event, callback);
        verify(broker, times(1)).notifySubscribers(topic, event);
        verify(callback, times(1)).run();
    }

    @Test
    void testNotifySubscribersWithEventWithoutCallback() {
        proxyPublisher.notifySubscribers(topic, event);
        verify(broker, times(1)).notifySubscribers(topic, event);
        verify(callback, never()).run();
    }
}
