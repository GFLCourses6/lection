package com.gfl.pubsub.subscriber;

import com.gfl.pubsub.Message;

public interface Subscriber {

    void receiveMessage(Message message);
}
