package ua.chemerys;

import static ua.chemerys.Constant.*;

public class PublisherSubscriberPattern {
    public static void main(String[] args) {

        Publisher publisher = new LoggerPublisher();
        Subscriber infoSubscriber = new InfoSubscriber();
        Subscriber warningSubscriber = new WarningSubscriber();

        publisher.subscribe(TOPIC_INFO, infoSubscriber);
        publisher.subscribe(TOPIC_WARNING, warningSubscriber);

        publisher.subscribe(TOPIC_DEBUG, infoSubscriber, warningSubscriber);

        publisher.publish();

        publisher.unsubscribe(TOPIC_DEBUG, infoSubscriber);

        publisher.publish();


    }
}