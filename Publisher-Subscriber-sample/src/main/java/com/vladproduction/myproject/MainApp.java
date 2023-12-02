package com.vladproduction.myproject;

import com.vladproduction.myproject.model.Message;
import com.vladproduction.myproject.publisher.Publisher;
import com.vladproduction.myproject.publisher.PublisherSimple;
import com.vladproduction.myproject.service.LocalMessagingService;
import com.vladproduction.myproject.service.MessagingService;
import com.vladproduction.myproject.service.MessagingServiceFactory;
import com.vladproduction.myproject.service.MessagingServiceType;
import com.vladproduction.myproject.subscriber.Subscriber;
import com.vladproduction.myproject.subscriber.SubscriberInfo;

import static com.vladproduction.myproject.model.Topic.*;
import static com.vladproduction.myproject.service.MessagingServiceFactory.*;
import static com.vladproduction.myproject.service.MessagingServiceType.*;

public class MainApp {
    public static void main(String[] args) {


        MessagingService messagingService = messagingService(LOCAL);

        Publisher simplePublisher = new PublisherSimple(messagingService);
        simplePublisher.publish(INFO_TOPIC, new Message("information"));

        Subscriber subInfo = new SubscriberInfo(messagingService);
        subInfo.subscribe(INFO_TOPIC);

        Subscriber subInfo2 = new SubscriberInfo(messagingService);
        subInfo2.subscribe(INFO_TOPIC);
        subInfo2.subscribe(WARNING_TOPIC);

        simplePublisher.publish(INFO_TOPIC, new Message("information# 2"));
        simplePublisher.publish(INFO_TOPIC, new Message("information# 3"));

        messagingService.shutDown();

    }
}
