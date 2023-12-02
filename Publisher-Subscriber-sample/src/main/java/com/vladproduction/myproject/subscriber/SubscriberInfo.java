package com.vladproduction.myproject.subscriber;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.service.LocalMessagingService;
import com.vladproduction.myproject.service.MessagingService;

public class SubscriberInfo implements Subscriber {

    private final MessagingService messagingService;

    public SubscriberInfo(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public void subscribe(Topic topic) {
        messagingService.subscribe(topic, this);
    }

    @Override
    public void unSubscribe(Topic topic) {
        messagingService.unSubscribe(topic, this);
    }

    @Override
    public void receiveMessage(Message message) {

        System.out.println("receive message start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Info message: " + message);

        System.out.println("receive message finish");

    }
}
