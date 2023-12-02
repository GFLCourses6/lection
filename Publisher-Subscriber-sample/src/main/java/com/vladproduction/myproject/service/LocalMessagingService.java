package com.vladproduction.myproject.service;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.subscriber.Subscriber;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalMessagingService implements MessagingService{

    private final EnumMap<Topic, Set<Subscriber>> topicSubscriberEnumMap;

    private ExecutorService executorService;




    public LocalMessagingService() {
        this.topicSubscriberEnumMap = new EnumMap<>(Topic.class);
        for(Topic topic: Topic.values()){
            topicSubscriberEnumMap.put(topic, new HashSet<>());
        }
        executorService = Executors.newFixedThreadPool(10);
    }


    public void subscribe(Topic topic, Subscriber... subscribers) {
        Arrays.stream(subscribers).forEach(subscriber -> topicSubscriberEnumMap.computeIfAbsent(topic, t->new HashSet<>())
                .add(subscriber));

    }


    public void unSubscribe(Topic topic, Subscriber... subscriber) {
        topicSubscriberEnumMap.getOrDefault(topic, new HashSet<>()).remove(subscriber);

    }


    public void publish(Topic topic, Message message) {
        Set<Subscriber> subscribers = topicSubscriberEnumMap.get(topic);
        System.out.println("publish to topic = " + topic + " amount of subscribers = " + subscribers.size());
        for (Subscriber subscriber: subscribers) {
//            subscriber.receiveMessage(message); //only when previous finish - start to sending new message to subscriber
            NotificationTask notificationTask = new NotificationTask(subscriber, message);
            executorService.execute(notificationTask);
        }
    }

    public void shutDown(){
        executorService.shutdown();
    }
}
