package com.vladproduction.myproject.service;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.model.Topic;
import com.vladproduction.myproject.subscriber.Subscriber;

public interface MessagingService {



    public void subscribe(Topic topic, Subscriber... subscribers);

    public void unSubscribe(Topic topic, Subscriber... subscriber);


    public void publish(Topic topic, Message message);


    public void shutDown();
}
