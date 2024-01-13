package com.gfl.prokhnov.example.patterns.pabsub.subscriber;

public interface Subscriber {
    void receiveMessage(String message);
    String getId();
}
