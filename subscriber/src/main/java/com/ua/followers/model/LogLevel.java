package com.ua.followers.model;

import com.ua.followers.subscriber.Subscriber;
import com.ua.followers.subscriber.SubscriberDebug;
import com.ua.followers.subscriber.SubscriberError;
import com.ua.followers.subscriber.SubscriberInfo;
import com.ua.followers.subscriber.SubscriberTrace;
import com.ua.followers.subscriber.SubscriberWarning;

public enum LogLevel {
    INFO(new SubscriberInfo()),

    WARN(new SubscriberWarning()),

    DEBUG(new SubscriberDebug()),

    TRACE(new SubscriberTrace()),

    ERROR(new SubscriberError());

    private final Subscriber subscriber;

    LogLevel(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
