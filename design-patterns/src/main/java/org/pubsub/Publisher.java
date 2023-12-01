package org.pubsub;

public interface Publisher {
    void subscribe(String topic, Subscriber... subscribers);

    void unsubscribe(String topic, Subscriber subscriber);

    void publish();

    void publish(String message, String... topics);
}
