package com.gfl.prokhnov.example.patterns.pabsub.publisher;

import com.gfl.prokhnov.example.patterns.pabsub.subscriber.Subscriber;

public interface Publisher {
    void subscribe(String topic, Subscriber... subscribers);
    void unsubscribe(String topic, Subscriber subscriber);
    void publish(String topic, String message);
}
