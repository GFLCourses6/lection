package com.ua.observer.broker;

import com.ua.observer.publisher.Publisher;
import com.ua.observer.subscriber.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class QueueBrokerRunnerTest {

    private QueueBroker broker;
    private QueueBrokerRunner runner;
    private Subscriber subscriber;
    private Publisher publisher;
    private Runnable callback;
    private Message message;
    private String topic;
    private Event event;

    @BeforeEach
    void setUp() {
        topic = "test";
        event = mock(Event.class);
        message = mock(Message.class);
        callback = mock(Runnable.class);
        publisher = mock(Publisher.class);
        subscriber = mock(Subscriber.class);
        broker = new QueueBroker();
        runner = new QueueBrokerRunner();
    }

    @Test
    void testNotifySubscribersWithEvent() {
        broker.subscribe(topic, subscriber);
        broker.notifySubscribers(topic, event);
        verify(subscriber, times(1)).update(event);
        verify(callback, never()).run();
    }

    @Test
    void testSubscribeVoid() {
        runner.subscribe(topic, subscriber, callback);
        verify(callback, times(1)).run();
        assertTrue(runner.getSubscribers().containsKey(topic));
        assertTrue(runner.getSubscribers().get(topic).contains(subscriber));
        verify(callback, times(1)).run();
    }

    @Test
    void testNotifySubscribersWithMessage() {
        broker.subscribe(topic, subscriber);
        broker.notifySubscribers(topic, message);
        verify(subscriber, times(1)).receiveMessage(message);
        verify(callback, never()).run();
    }

    @Test
    void testPublishEvent() {
        broker.subscribe(topic, subscriber);
        broker.publishEvent(topic, message);
        verify(callback, never()).run();
    }

    @Test
    void testAddPublisher() {
        runner.addPublisher(topic, publisher, callback);
        verify(callback, times(1)).run();
        assertEquals(publisher, runner.getPublishers().get(topic));
    }

    @Test
    void testRemovePublisher() {
        runner.addPublisher(topic, publisher);
        runner.removePublisher(topic, callback);
        verify(callback, times(1)).run();
        assertNull(runner.getPublishers().get(topic));
    }

    @Test
    void testUnsubscribe() {
        runner.subscribe(topic, subscriber);
        runner.unsubscribe(topic, subscriber, callback);
        verify(callback, times(1)).run();
        assertFalse(runner.getSubscribers().get(topic).contains(subscriber));
    }

    @Test
    void testNotifySubscribersWithEventVoid() {
        runner.subscribe(topic, subscriber);
        runner.notifySubscribers(topic, event, callback);
        verify(callback, times(1)).run();
        verify(subscriber, times(1)).update(event);
    }

    @Test
    void testPublishEventVoid() {
        runner.subscribe(topic, subscriber);
        runner.publishEvent(topic, message, callback);
        verify(callback, times(1)).run();
//        assertEquals(1, runner.getEventQueue().size());
//        verify(subscriber, times(1)).receiveMessage(message);
    }

    @Test
    void testAddAndRemovePublisher() {
        runner.addPublisher(topic, publisher, callback);
        runner.removePublisher(topic);
        verify(callback, times(1)).run();
    }

    @Test
    void testSubscribeAndUnsubscribe() {
        runner.subscribe(topic, subscriber, callback);
        runner.unsubscribe(topic, subscriber);
        verify(callback, times(1)).run();
    }

    @Test
    void testNotifySubscribersWithMessageVoid() {
        runner.subscribe(topic, subscriber, callback);
        runner.notifySubscribers(topic, message, callback);
        verify(callback, times(2)).run();
        verify(subscriber, times(1)).receiveMessage(message);
    }

    @Test
    void testAddAndRemovePublisherWithoutCallback() {
        broker.addPublisher(topic, publisher);
        assertNotNull(broker.getPublishers().get(topic));
        broker.removePublisher(topic);
        assertNull(broker.getPublishers().get(topic));
        verify(callback, never()).run();
    }

    @Test
    void testSubscribeAndUnsubscribeWithCallback() {
        runner.subscribe(topic, subscriber, callback);
        verify(callback, times(1)).run();
        assertTrue(runner.getSubscribers().containsKey(topic));
        assertTrue(runner.getSubscribers().get(topic).contains(subscriber));
        runner.unsubscribe(topic, subscriber, callback);
        verify(callback, times(2)).run();
        assertFalse(runner.getSubscribers().get(topic).contains(subscriber));
        verifyNoMoreInteractions(callback);
    }

    @Test
    void testAddAndRemovePublisherWithCallback() {
        runner.addPublisher(topic, publisher, callback);
        verify(callback, times(1)).run();
        assertEquals(publisher, runner.getPublishers().get(topic));
        runner.removePublisher(topic, callback);
        verify(callback, times(2)).run();
        assertNull(runner.getPublishers().get(topic));
    }

    @Test
    void testSubscribeAndUnsubscribeWithoutCallback() {
        broker.subscribe(topic, subscriber);
        assertTrue(broker.getSubscribers().get(topic).contains(subscriber));
        broker.unsubscribe(topic, subscriber);
        assertFalse(broker.getSubscribers().get(topic).contains(subscriber));
        verify(callback, never()).run();
    }

    @Test
    void testNotifySubscribersWithEventWithCallback() {
        runner.subscribe(topic, subscriber);
        runner.notifySubscribers(topic, event, callback);
        verify(callback, times(1)).run();
        verify(subscriber, times(1)).update(event);
    }

    @Test
    void testNotifySubscribersWithEventWithoutCallback() {
        broker.subscribe(topic, subscriber);
        broker.notifySubscribers(topic, event);
        verify(subscriber, times(1)).update(event);
        verify(callback, never()).run();
    }

    @Test
    void testNotifySubscribersWithReceiveMessageWithCallback() {
        runner.subscribe(topic, subscriber, callback);
        runner.notifySubscribers(topic, message, callback);
        verify(callback, times(2)).run();
        verify(subscriber, times(1)).receiveMessage(message);
    }

    @Test
    void testNotifySubscribersWithMessageWithoutCallback() {
        broker.subscribe(topic, subscriber);
        broker.notifySubscribers(topic, message);
        verify(subscriber, times(1)).receiveMessage(message);
        verify(callback, never()).run();
    }

    @Test
    void testNotifySubscribersWithMessageWithCallback() {
        runner.subscribe(topic, subscriber, callback);
        runner.notifySubscribers(topic, message);
        verify(callback, times(1)).run();
        verify(subscriber, times(1)).receiveMessage(message);
    }

    @Test
    void testAddAndRemovePublisherWithCallbackVoid() {
        runner.addPublisher(topic, publisher, callback);
        verify(callback, times(1)).run();
        assertEquals(publisher, runner.getPublishers().get(topic));
        runner.removePublisher(topic, callback);
        verify(callback, times(2)).run();
        assertNull(broker.getPublishers().get(topic));
    }

    @Test
    void testAddAndRemovePublisherWithoutCallbackWithoutCallback() {
        broker.addPublisher(topic, publisher);
        assertNotNull(broker.getPublishers().get(topic));
        broker.removePublisher(topic);
        assertNull(broker.getPublishers().get(topic));
        verify(callback, never()).run();
    }

    @Test
    void testSubscribeAndUnsubscribeWithCallbackVoid() {
        runner.subscribe(topic, subscriber, callback);
        verify(callback, times(1)).run();
        assertTrue(runner.getSubscribers().containsKey(topic));
        assertTrue(runner.getSubscribers().get(topic).contains(subscriber));
        runner.unsubscribe(topic, subscriber, callback);
        verify(callback, times(2)).run();
        assertFalse(runner.getSubscribers().get(topic).contains(subscriber));
    }

    @Test
    void testSubscribeAndUnsubscribeWithoutCallbackWithoutCallback() {
        broker.subscribe(topic, subscriber);
        assertTrue(broker.getSubscribers().containsKey(topic));
        assertTrue(broker.getSubscribers().get(topic).contains(subscriber));
        broker.unsubscribe(topic, subscriber);
        assertFalse(broker.getSubscribers().get(topic).contains(subscriber));
        verify(callback, never()).run();
    }

    @Test
    void testPublishEvents() {
        runner.publishEvent(topic, message, callback);
        verify(callback, times(1)).run();
        assertEquals(1, runner.getEventQueue().size());
        Event expectedEvent = new Event(message);
        assertTrue(runner.getEventQueue().contains(expectedEvent));
    }

    @Test
    void testNotifySubscribers() {
        broker.subscribe(topic, subscriber);
        runner.notifySubscribers(topic, event, callback);
        verify(callback, times(1)).run();
        assertEquals(1, runner.getEventQueue().size());
    }
}
