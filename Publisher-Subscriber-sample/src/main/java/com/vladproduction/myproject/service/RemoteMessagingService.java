package com.vladproduction.myproject.service;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.subscriber.Subscriber;

public class RemoteMessagingService implements MessagingService {
    @Override
    public void subscribe(Topic topic, Subscriber... subscribers) {

    }

    @Override
    public void unSubscribe(Topic topic, Subscriber... subscriber) {

    }

    @Override
    public void publish(Topic topic, Message message) {

    }

    @Override
    public void shutDown() {

    }
}
