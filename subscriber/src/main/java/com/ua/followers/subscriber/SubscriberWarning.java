package com.ua.followers.subscriber;

import com.ua.followers.model.Message;

import static com.ua.followers.model.LogLevel.WARN;

public class SubscriberWarning
        implements Subscriber {

    private boolean isReceived;

    @Override
    public void receive(Message message) {
        System.out.printf("\u001B[33mLevel#%s, message: %s%n",
                          getId(),
                          message);
        isReceived = true;
    }

    @Override
    public Integer getId() {
        return WARN.ordinal();
    }

    @Override
    public boolean hasReceived() {
        return isReceived;
    }
}
