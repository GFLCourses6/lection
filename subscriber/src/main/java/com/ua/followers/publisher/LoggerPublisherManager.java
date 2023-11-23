package com.ua.followers.publisher;

import com.ua.followers.model.LogLevel;
import com.ua.followers.model.Message;
import com.ua.followers.subscriber.Subscriber;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static com.ua.followers.model.LogLevel.*;

public class LoggerPublisherManager
        implements Publisher {

    private final EnumMap<LogLevel, Set<Subscriber>> levelSubscribers;

    public LoggerPublisherManager() {
        this.levelSubscribers = new EnumMap<>(LogLevel.class);
        for (LogLevel level : LogLevel.values()) {
            levelSubscribers.put(level, new HashSet<>());
        }
    }

    @Override
    public void subscribe(
            LogLevel level,
            Subscriber... subscribers) {
        Arrays.stream(subscribers)
              .forEach(subscriber -> levelSubscribers
                      .computeIfAbsent(level, k -> new HashSet<>())
                      .add(subscriber));
    }

    @Override
    public void unsubscribe(
            LogLevel level,
            Subscriber subscriber) {
        levelSubscribers.getOrDefault(level, new HashSet<>())
                .remove(subscriber);
    }

    @Override
    public void publish(LogLevel level, Message message) {
        levelSubscribers.getOrDefault(level, new HashSet<>())
                        .forEach(getSubscriberConsumer(message));
    }

    public boolean containsSubscriber(LogLevel level, Subscriber subscriber) {
        return levelSubscribers.getOrDefault(level, new HashSet<>()).contains(subscriber);
    }

    private static Consumer<Subscriber> getSubscriberConsumer(Message message) {
        return subscriber -> subscriber.receive(message);
    }

    public int getDebugLevel() {
        return DEBUG.ordinal() - WARN.ordinal() + INFO.ordinal();
    }
}
