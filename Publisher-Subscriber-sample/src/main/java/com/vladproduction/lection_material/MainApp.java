package com.vladproduction.lection_material;

import static com.vladproduction.lection_material.Constant.*;

public class MainApp {
    public static void main(String[] args) {
        Publisher loggerPublisher = new LoggerPublisher();
        Subscriber subscriberInfo = new SubscriberInfo();
        Subscriber subscriberWarning = new SubscriberWarning();

        System.out.println("----------subscribe:----------");
        loggerPublisher.subscribe(TOPIC_INFO, subscriberInfo);
        loggerPublisher.subscribe(TOPIC_WARNING, subscriberWarning);
        loggerPublisher.subscribe(TOPIC_DEBUG, subscriberInfo, subscriberWarning);
        loggerPublisher.publish();

        System.out.println("----------unSubscribe: TOPIC_DEBUG (warnings)----------");
        loggerPublisher.unSubscribe(TOPIC_DEBUG, subscriberInfo);
        loggerPublisher.publish();
    }
}
