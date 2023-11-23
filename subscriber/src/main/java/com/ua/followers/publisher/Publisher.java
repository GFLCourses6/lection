package com.ua.followers.publisher;

import com.ua.followers.model.LogLevel;
import com.ua.followers.model.Message;
import com.ua.followers.subscriber.Subscriber;

public interface Publisher {

    void subscribe(
            LogLevel level,
            Subscriber... subscribers);

    void unsubscribe(
            LogLevel level,
            Subscriber subscriber);

    void publish(
            LogLevel level,
            Message message);

    boolean containsSubscriber(
            LogLevel logLevel,
            Subscriber subscriber);
}
