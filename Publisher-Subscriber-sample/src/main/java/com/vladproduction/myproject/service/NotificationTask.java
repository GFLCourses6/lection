package com.vladproduction.myproject.service;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.subscriber.Subscriber;

public class NotificationTask implements Runnable{

    private final Subscriber subscriber;
    private final Message message;

    public NotificationTask(Subscriber subscriber, Message message) {
        this.subscriber = subscriber;
        this.message = message;
    }

    @Override
    public void run() {
        subscriber.receiveMessage(message); //one of our thread work , but other can take job and start immediately
    }
}
