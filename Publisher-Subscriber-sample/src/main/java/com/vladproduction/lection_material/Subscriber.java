package com.vladproduction.lection_material;

public interface Subscriber {

    void receiveMessage(String message);
    String getId();
}
