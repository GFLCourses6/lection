package com.vladproduction.myproject.subscriber;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.service.LocalMessagingService;

public class SubscriberWarning implements Subscriber {

    private LocalMessagingService localMessagingService;

    public SubscriberWarning(LocalMessagingService localMessagingService) {
        this.localMessagingService = localMessagingService;
    }

    @Override
    public void subscribe(Topic topic) {
        localMessagingService.subscribe(topic, this);
    }

    @Override
    public void unSubscribe(Topic topic) {
        localMessagingService.unSubscribe(topic, this);
    }

    @Override
    public void receiveMessage(Message message) {

        System.out.println("Warning message: " + message);
    }
}
