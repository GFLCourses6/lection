package org.pubsub;

import static org.pubsub.Constant.*;

public class PublisherSubscriber {
    public static void main(String[] args) {
        Publisher publisher = new LoggerPublisher();
        Subscriber subscriberInfo = new SubscriberInfo();
        Subscriber subscriberWarning = new SubscriberWarning();

        publisher.subscribe(TOPIC_INFO, subscriberInfo);
        publisher.subscribe(TOPIC_WARNING, subscriberWarning);
//        publisher.subscribe(TOPIC_DEBUG, subscriberInfo, subscriberWarning);
//
//        publisher.publish();
//
//        publisher.unsubscribe(TOPIC_DEBUG, subscriberInfo);
//        publisher.publish();

        publisher.publish("Warning message", TOPIC_WARNING, TOPIC_INFO);
    }
}
