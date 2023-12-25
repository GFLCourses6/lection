package com.gfl.pubsub.publisher;

import com.gfl.pubsub.Message;
import com.gfl.pubsub.subscriber.Subscriber;

import java.util.*;
import java.util.function.Consumer;

public class NewsPublisher implements Publisher {

    Map<String, List<Subscriber>> topicSubscribers;

    public NewsPublisher() {
        this.topicSubscribers = new HashMap<>();
        Arrays.stream(NewsConstants.values())
                .forEach(topic -> topicSubscribers.put(topic.getTopic(), new ArrayList<>()));

    }

    @Override
    public void subscribe(String topic, Subscriber... subscribers) {
        doInTopic(topic, list -> list.addAll(List.of(subscribers)));
    }

    @Override
    public void unsubscribe(String topic, Subscriber... subscribers) {
        doInTopic(topic, list -> list.removeAll(List.of(subscribers)));
    }

    @Override
    public void publish(String topic, Message message) {
        topicSubscribers.get(topic)
                .forEach(sub -> sub.receiveMessage(message));
    }

    private void doInTopic(String topic, Consumer<List<Subscriber>> consumer) {
        Optional.ofNullable(topicSubscribers.get(topic))
                .ifPresentOrElse(
                        consumer,
                        () -> { throw new IllegalArgumentException("Topic doesn't exist, name: " + topic); }
                );
    }
}
