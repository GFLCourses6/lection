package com.vladproduction.myproject.service;

public class MessagingServiceFactory {

    public static MessagingService messagingService(MessagingServiceType messagingServiceType){

        switch (messagingServiceType){
            case LOCAL : return new LocalMessagingService();
            case REMOTE: return new RemoteMessagingService();
            default: throw new RuntimeException();
        }

    };


}
