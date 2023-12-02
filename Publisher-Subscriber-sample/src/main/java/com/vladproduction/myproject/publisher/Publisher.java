package com.vladproduction.myproject.publisher;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;

public interface Publisher {

    void publish(Topic topic, Message message);
}
