package com.vladproduction.demo;

public class MainAppDemo {
    public static void main(String[] args) {
        // Create the message broker
        MessagePublisher broker = new MessagePublisher();

        // Create a subscriber and subscribe it to the broker
        ExampleSubscriber subscriber = new ExampleSubscriber();
        broker.subscribe(subscriber);

        // Publish a message
        broker.publish("Hello, world!");

        // Unsubscribe the subscriber
        broker.unsubscribe(subscriber);

        // Publish another message
        broker.publish("Goodbye, world!");
    }
}
