package com.gfl.pubsub.publisher;

import com.gfl.pubsub.Message;
import com.gfl.pubsub.subscriber.Subscriber;

public interface Publisher {

    void subscribe(String topic, Subscriber... subscribers);

    void unsubscribe(String topic, Subscriber... subscribers);

    void publish(String topic, Message message);
}
