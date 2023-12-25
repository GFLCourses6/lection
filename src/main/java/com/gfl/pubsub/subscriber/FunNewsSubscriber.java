package com.gfl.pubsub.subscriber;

import com.gfl.pubsub.Message;

public class FunNewsSubscriber implements Subscriber {

    @Override
    public void receiveMessage(Message message) {
        System.out.println("Fun message processing: " + message);
    }
}
