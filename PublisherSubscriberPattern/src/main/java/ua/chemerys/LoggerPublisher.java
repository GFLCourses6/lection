package ua.chemerys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.chemerys.Constant.*;

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
    public void publish() {
        List<Subscriber> infoSubscribers = topicsSubscribers.get(TOPIC_INFO);
        publish(infoSubscribers, "INFO : message");

        List<Subscriber> warningSubscribers = topicsSubscribers.get(TOPIC_WARNING);
        publish(warningSubscribers, "WARNING : message");

        List<Subscriber> debugSubscribers = topicsSubscribers.get(TOPIC_DEBUG);
        publish(debugSubscribers, "DEBUG : message");
    }

    private void publish(List<Subscriber> subscribers, String message) {
        subscribers.forEach(subscriber -> subscriber.receiveMessage(message));
    }
}
