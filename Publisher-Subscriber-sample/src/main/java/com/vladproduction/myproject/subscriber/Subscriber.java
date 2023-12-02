package com.vladproduction.myproject.subscriber;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;

public interface Subscriber {

    void subscribe(Topic topic);

    void unSubscribe(Topic topic);

    void receiveMessage(Message message);

}
