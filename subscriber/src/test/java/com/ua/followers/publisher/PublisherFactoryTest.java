package com.ua.followers.publisher;

import com.ua.followers.model.Message;
import com.ua.followers.subscriber.Subscriber;
import com.ua.followers.subscriber.SubscriberDebug;
import com.ua.followers.subscriber.SubscriberInfo;
import com.ua.followers.subscriber.SubscriberTrace;
import com.ua.followers.subscriber.SubscriberWarning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ua.followers.model.LogLevel.DEBUG;
import static com.ua.followers.model.LogLevel.ERROR;
import static com.ua.followers.model.LogLevel.INFO;
import static com.ua.followers.model.LogLevel.TRACE;
import static com.ua.followers.model.LogLevel.WARN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublisherFactoryTest {

    private Publisher manager;
    private Subscriber subscriberInfo;
    private Subscriber subscriberWarning;

    @BeforeEach
    void setUp() {
        manager = PublisherFactory.getPublisher();
        subscriberInfo = new SubscriberInfo();
        subscriberWarning = new SubscriberWarning();
    }

    @Test
    void testSubscribes() {

        Subscriber errorSubscriber = ERROR.getSubscriber();

        manager.subscribe(INFO, subscriberInfo, subscriberWarning);
        manager.subscribe(WARN, subscriberWarning);
        manager.subscribe(ERROR, errorSubscriber);

        assertTrue(manager.containsSubscriber(INFO, subscriberInfo));
        assertTrue(manager.containsSubscriber(INFO, subscriberWarning));
        assertTrue(manager.containsSubscriber(WARN, subscriberWarning));
        assertTrue(manager.containsSubscriber(ERROR, errorSubscriber));

        manager.publish(INFO, new Message("Information"));
        manager.publish(WARN, new Message("Warning"));
        manager.publish(ERROR, new Message("Error"));

        assertTrue(subscriberInfo.hasReceived());
        assertTrue(subscriberWarning.hasReceived());
        assertTrue(errorSubscriber.hasReceived());

        assertEquals(INFO.ordinal(), subscriberInfo.getId());
        assertEquals(WARN.ordinal(), subscriberWarning.getId());
        assertEquals(ERROR.ordinal(), errorSubscriber.getId());
    }

    @Test
    void testPublish() {
        manager.subscribe(INFO, subscriberInfo, subscriberWarning);
        manager.subscribe(WARN, subscriberWarning);
        manager.subscribe(ERROR, ERROR.getSubscriber());
        manager.publish(INFO, new Message("Information"));
        assertTrue(subscriberInfo.hasReceived());
        assertEquals(INFO.ordinal(), subscriberInfo.getId());
        manager.publish(WARN, new Message("Warning"));
        assertTrue(subscriberWarning.hasReceived());
        assertEquals(WARN.ordinal(), subscriberWarning.getId());
    }

    @Test
    void testUnsubscribe() {
        Publisher manager = PublisherFactory.getPublisher();
        Subscriber subscriberInfo = new SubscriberInfo();
        Subscriber subscriberWarning = new SubscriberWarning();
        manager.subscribe(INFO, subscriberInfo, subscriberWarning);
        manager.subscribe(WARN, subscriberWarning);
        manager.subscribe(ERROR, ERROR.getSubscriber());
        manager.unsubscribe(INFO, subscriberInfo);
        manager.publish(INFO, new Message("unsubscribing Info"));
        assertFalse(subscriberInfo.hasReceived());
    }

    @Test
    void testSubscribeUnsubscribeAndPublish() {
        manager.subscribe(INFO, subscriberInfo, subscriberWarning);
        manager.subscribe(WARN, subscriberWarning);
        manager.subscribe(ERROR, ERROR.getSubscriber());

        assertTrue(manager.containsSubscriber(INFO, subscriberInfo));
        assertTrue(manager.containsSubscriber(INFO, subscriberWarning));
        assertTrue(manager.containsSubscriber(WARN, subscriberWarning));
        assertTrue(manager.containsSubscriber(ERROR, ERROR.getSubscriber()));

        manager.publish(INFO, new Message("Information"));
        assertTrue(subscriberInfo.hasReceived());
        assertEquals(INFO.ordinal(), subscriberInfo.getId());
        manager.publish(WARN, new Message("Warning"));
        assertTrue(subscriberWarning.hasReceived());
        assertEquals(WARN.ordinal(), subscriberWarning.getId());
        manager.unsubscribe(INFO, subscriberInfo);
        assertFalse(manager.containsSubscriber(INFO, subscriberInfo));
        manager.publish(INFO, new Message("unsubscribing Info"));
        assertTrue(subscriberInfo.hasReceived());
    }

    @Test
    void testSubscriberDebug() {
        Publisher manager = PublisherFactory.getPublisher();
        Subscriber subscriberDebug = new SubscriberDebug();
        manager.subscribe(DEBUG, subscriberDebug);
        assertTrue(manager.containsSubscriber(DEBUG, subscriberDebug));
        manager.publish(DEBUG, new Message("Debugging"));
        assertTrue(subscriberDebug.hasReceived());
        assertEquals(DEBUG.ordinal(), subscriberDebug.getId());
        manager.unsubscribe(DEBUG, subscriberDebug);
        assertFalse(manager.containsSubscriber(DEBUG, subscriberDebug));
    }

    @Test
    void testSubscriberTrace() {
        Subscriber subscriberTrace = new SubscriberTrace();
        manager.subscribe(TRACE, subscriberTrace);
        assertTrue(manager.containsSubscriber(TRACE, subscriberTrace));
        manager.publish(TRACE, new Message("Tracing"));
        assertTrue(subscriberTrace.hasReceived());
        assertEquals(TRACE.ordinal(), subscriberTrace.getId());
        manager.unsubscribe(TRACE, subscriberTrace);
        assertFalse(manager.containsSubscriber(TRACE, subscriberTrace));
    }

    @Test
    void testSubscriberDebugLevels() {
        Subscriber subscriberDebug = new SubscriberDebug();
        manager.subscribe(DEBUG, subscriberDebug);
        assertTrue(manager.containsSubscriber(DEBUG, subscriberDebug));
        manager.subscribe(WARN, subscriberDebug);
        assertTrue(manager.containsSubscriber(WARN, subscriberDebug));
        manager.subscribe(INFO, subscriberDebug);
        assertTrue(manager.containsSubscriber(INFO, subscriberDebug));
        manager.publish(DEBUG, new Message("Debugging"));
        assertTrue(subscriberDebug.hasReceived());
        assertEquals(DEBUG.ordinal(), subscriberDebug.getId());
        manager.publish(WARN, new Message("Warning"));
        assertTrue(subscriberDebug.hasReceived());
        assertTrue(WARN.ordinal() < subscriberDebug.getId());
        manager.publish(INFO, new Message("Information"));
        assertTrue(subscriberDebug.hasReceived());
        assertTrue(INFO.ordinal() < subscriberDebug.getId());
        manager.unsubscribe(DEBUG, subscriberDebug);
        assertFalse(manager.containsSubscriber(DEBUG, subscriberDebug));
        manager.unsubscribe(WARN, subscriberDebug);
        assertFalse(manager.containsSubscriber(WARN, subscriberDebug));
        manager.unsubscribe(INFO, subscriberDebug);
        assertFalse(manager.containsSubscriber(INFO, subscriberDebug));
    }
}
