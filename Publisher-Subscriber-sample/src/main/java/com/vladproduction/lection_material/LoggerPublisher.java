package com.vladproduction.lection_material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vladproduction.lection_material.Constant.*;

public class LoggerPublisher implements Publisher{

    private Map<String, List<Subscriber>> topicsSubscribers;

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
    public void unSubscribe(String topic, Subscriber subscriber) {
        topicsSubscribers.get(topic).remove(subscriber);
    }

    @Override
    public void publish() {
        List<Subscriber> infoSubscribersList = topicsSubscribers.get(TOPIC_INFO);
        publish(infoSubscribersList, "INFO: info_message");

        List<Subscriber> warningSubscribersList = topicsSubscribers.get(TOPIC_WARNING);
        publish(warningSubscribersList, "WARNING: warning_message");

        List<Subscriber> debugSubscribersList = topicsSubscribers.get(TOPIC_DEBUG);
        publish(debugSubscribersList, "DEBUG: debug_message");
    }

    private void publish(List<Subscriber> subscriberList, String message){
//        for (Subscriber subscriber: subscriberList) {
//            subscriber.receiveMessage(message);
//        }
        subscriberList.forEach(s->s.receiveMessage(message));

    }
}
