package org.pubsub;

public interface Subscriber {
    void receiveMessage(String message);

    String getID();

}
