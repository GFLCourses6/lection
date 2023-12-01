package org.pubsub;

public class SubscriberInfo implements Subscriber{
    @Override
    public void receiveMessage(String message) {
        System.out.println(String.format("Reading message = %s by subscriber = %s", message, this.getID()));
    }


    @Override
    public String getID() {
        return "subscriber-info";
    }
}
