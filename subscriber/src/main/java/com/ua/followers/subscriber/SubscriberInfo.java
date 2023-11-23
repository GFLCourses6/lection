package com.ua.followers.subscriber;


import com.ua.followers.model.Message;

import static com.ua.followers.model.LogLevel.INFO;

public class SubscriberInfo
        implements Subscriber {

    private boolean isReceived;

    @Override
    public void receive(Message message) {
        System.out.printf("\u001B[34mLevel#%s, message: %s%n",
                          getId(),
                          message);
        isReceived = true;
    }

    @Override
    public Integer getId() {
        return INFO.ordinal();
    }

    @Override
    public boolean hasReceived() {
        return isReceived;
    }
}
