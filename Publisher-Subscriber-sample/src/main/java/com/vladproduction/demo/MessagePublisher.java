package com.vladproduction.demo;

import java.util.ArrayList;
import java.util.List;

class MessagePublisher {
    private List<MessageListener> listeners = new ArrayList<>();

    public void subscribe(MessageListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(MessageListener listener) {
        listeners.remove(listener);
    }

    public void publish(String message) {
        for (MessageListener listener : listeners) {
            listener.onMessageReceived(message);
        }
    }
}
