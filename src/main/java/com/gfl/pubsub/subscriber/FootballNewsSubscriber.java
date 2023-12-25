package com.gfl.pubsub.subscriber;

import com.gfl.pubsub.Message;

public class FootballNewsSubscriber implements Subscriber {

    @Override
    public void receiveMessage(Message message) {
        System.out.println(message.getCreatedAte());
        System.out.println("Processing a cool football message: " + message);
    }
}
