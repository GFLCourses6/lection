package com.gfl.pubsub;

import com.gfl.pubsub.publisher.NewsPublisher;
import com.gfl.pubsub.publisher.Publisher;
import com.gfl.pubsub.subscriber.CityNewsSubscriber;
import com.gfl.pubsub.subscriber.FootballNewsSubscriber;
import com.gfl.pubsub.subscriber.FunNewsSubscriber;
import com.gfl.pubsub.subscriber.Subscriber;


import static com.gfl.pubsub.publisher.NewsConstants.*;

public class Main {

    public static void main(String[] args) {
        Subscriber citySub = new CityNewsSubscriber();
        Subscriber footballSub = new FootballNewsSubscriber();
        Subscriber funSub = new FunNewsSubscriber();

        Publisher pub = new NewsPublisher();
        pub.subscribe(TOPIC_CITY.getTopic(), citySub);
        pub.subscribe(TOPIC_FOOTBALL.getTopic(), footballSub);
        pub.subscribe(TOPIC_FUN.getTopic(), footballSub);
        pub.subscribe(TOPIC_FUN.getTopic(), funSub);

        pub.publish(TOPIC_FUN.getTopic(), new Message("NEW FUN MESSAGE"));
        pub.publish(TOPIC_CITY.getTopic(), new Message("city message"));

        pub.unsubscribe(TOPIC_FUN.getTopic(), footballSub);
        pub.publish(TOPIC_FUN.getTopic(), new Message("ANOTHER FUN MESSAGE"));
    }
}
