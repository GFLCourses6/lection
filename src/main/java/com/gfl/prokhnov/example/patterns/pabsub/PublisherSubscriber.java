package com.gfl.prokhnov.example.patterns.pabsub;

import com.gfl.prokhnov.example.patterns.pabsub.publisher.LoggerPublisher;
import com.gfl.prokhnov.example.patterns.pabsub.publisher.Publisher;
import com.gfl.prokhnov.example.patterns.pabsub.subscriber.Subscriber;
import com.gfl.prokhnov.example.patterns.pabsub.subscriber.SubscriberInfo;
import com.gfl.prokhnov.example.patterns.pabsub.subscriber.SubscriberWarning;

import static com.gfl.prokhnov.example.patterns.pabsub.Constant.*;

public class PublisherSubscriber {
    public static void main(String[] args) {
        Publisher publisher = new LoggerPublisher();
        Subscriber subscriberInfo = new SubscriberInfo();
        Subscriber subscriberWarning = new SubscriberWarning();

        publisher.subscribe(TOPIC_INFO, subscriberInfo);
        publisher.subscribe(TOPIC_WARNING, subscriberWarning);
        publisher.subscribe(TOPIC_DEBUG, subscriberInfo, subscriberWarning);

        System.out.println("---");
        publisher.publish(TOPIC_INFO, "Test topic info message");
        publisher.publish(TOPIC_INFO, "Test topic info message2");
        publisher.publish(TOPIC_WARNING, "Test topic warning message");

        publisher.unsubscribe(TOPIC_WARNING, subscriberWarning);

        System.out.println("---");
        publisher.publish(TOPIC_INFO, "Test topic info message3");

    }
}
