package com.vladproduction.lection_material;

public interface Publisher {

    void subscribe(String topic, Subscriber...subscribers);
    void unSubscribe(String topic, Subscriber subscriber);
    void publish(); //need to add functionality
}
