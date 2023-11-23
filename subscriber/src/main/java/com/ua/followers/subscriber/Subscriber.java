package com.ua.followers.subscriber;

import com.ua.followers.model.Message;

public interface Subscriber {

    void receive(Message message);

    Integer getId();

    boolean hasReceived();
}
