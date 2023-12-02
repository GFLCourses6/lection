package com.vladproduction.lection_material;

public class SubscriberDebug implements Subscriber{
    @Override
    public void receiveMessage(String message) {
        System.out.println(String.format("reading message =  %s by subscriber - %s", message, this.getId()));
    }

    @Override
    public String getId() {
        return "subscriber-debug";
    }
}
