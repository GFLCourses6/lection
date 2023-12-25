package com.gfl.pubsub.publisher;

import lombok.Getter;

@Getter
public enum NewsConstants {

    TOPIC_FOOTBALL("football"),
    TOPIC_CITY("city"),
    TOPIC_FUN("fun");

    private final String topic;

    NewsConstants(String topic) {
        this.topic = topic;
    }
}
