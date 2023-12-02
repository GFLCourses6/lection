package com.vladproduction.myproject.publisher;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.service.MessagingService;

public class PublisherSimple implements Publisher {

    private final MessagingService messagingService;

    public PublisherSimple(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public void publish(Topic topic, Message message) {

        System.out.println("PublisherSimple publish to topic = " + topic + "message: " + message + "start");
        messagingService.publish(topic, message);
        System.out.println("PublisherSimple publish to topic = " + topic + "message: " + message + "finish");

    }
}
