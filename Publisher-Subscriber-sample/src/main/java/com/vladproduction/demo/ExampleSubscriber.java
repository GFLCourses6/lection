package com.vladproduction.demo;

class ExampleSubscriber implements MessageListener {
    @Override
    public void onMessageReceived(String message) {

        System.out.println("Received message: " + message);
    }
}
