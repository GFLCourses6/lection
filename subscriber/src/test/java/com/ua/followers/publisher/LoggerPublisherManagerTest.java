package com.ua.followers.publisher;

import com.ua.followers.model.Message;
import com.ua.followers.subscriber.Subscriber;
import com.ua.followers.subscriber.SubscriberInfo;
import org.junit.jupiter.api.Test;

import static com.ua.followers.model.LogLevel.DEBUG;
import static com.ua.followers.model.LogLevel.INFO;
import static com.ua.followers.model.LogLevel.WARN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerPublisherManagerTest {

    @Test
    void testSubscribe() {
        LoggerPublisherManager loggerManager = new LoggerPublisherManager();
        Subscriber subscriber = new SubscriberInfo();
        loggerManager.subscribe(INFO, subscriber);
        assertTrue(loggerManager.containsSubscriber(INFO, subscriber));
    }

    @Test
    void testUnsubscribe() {
        LoggerPublisherManager loggerManager = new LoggerPublisherManager();
        Subscriber subscriber = new SubscriberInfo();
        loggerManager.subscribe(INFO, subscriber);
        loggerManager.unsubscribe(INFO, subscriber);
        assertFalse(loggerManager.containsSubscriber(INFO, subscriber));
    }

    @Test
    void testPublish() {
        LoggerPublisherManager loggerManager = new LoggerPublisherManager();
        Subscriber subscriber = new SubscriberInfo();
        Message message = new Message("Test Message");
        loggerManager.subscribe(INFO, subscriber);
        loggerManager.publish(INFO, message);
        assertTrue((subscriber).hasReceived());
    }

    @Test
    void testGetDebugLevel() {
        LoggerPublisherManager loggerManager = new LoggerPublisherManager();
        int debugLevel = loggerManager.getDebugLevel();
        assertEquals(DEBUG.ordinal() - WARN.ordinal() + INFO.ordinal(),
                     debugLevel);
    }

}
