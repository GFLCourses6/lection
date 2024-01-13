package com.gfl.prokhnov.example.patterns.pabsub.subscriber;

public class SubscriberInfo implements Subscriber{
    @Override
    public void receiveMessage(String message) {
        System.out.printf("Reading message = %s by subscriber = %s%n", message, this.getId());
    }

    @Override
    public String getId() {
        return "subscriber-info";
    }
}
