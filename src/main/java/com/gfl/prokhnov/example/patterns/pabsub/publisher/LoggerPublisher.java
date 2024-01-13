package com.gfl.prokhnov.example.patterns.pabsub.publisher;

import com.gfl.prokhnov.example.patterns.pabsub.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gfl.prokhnov.example.patterns.pabsub.Constant.*;

public class LoggerPublisher implements Publisher {

    Map<String, List<Subscriber>> topicsSubscribers;

    public LoggerPublisher() {
        this.topicsSubscribers = new HashMap<>();
        topicsSubscribers.put(TOPIC_INFO, new ArrayList<>());
        topicsSubscribers.put(TOPIC_WARNING, new ArrayList<>());
        topicsSubscribers.put(TOPIC_DEBUG, new ArrayList<>());
    }

    @Override
    public void subscribe(String topic, Subscriber... subscribers) {
        topicsSubscribers.get(topic).addAll(List.of(subscribers));
    }

    @Override
    public void unsubscribe(String topic, Subscriber subscriber) {
        topicsSubscribers.get(topic).remove(subscriber);
    }

    @Override
    public void publish(String topic, String message) {
        List<Subscriber> subscribers = topicsSubscribers.get(topic);
        for (Subscriber subscriber :subscribers){
            subscriber.receiveMessage(message);
        }
    }
}
