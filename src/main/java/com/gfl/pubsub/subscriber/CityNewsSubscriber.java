package com.gfl.pubsub.subscriber;

import com.gfl.pubsub.Message;

public class CityNewsSubscriber implements Subscriber {

    @Override
    public void receiveMessage(Message message) {
        System.out.println("TIME: " + message.getCreatedAte());
        System.out.println("Processing city message: " + message);
    }
}