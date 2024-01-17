package ua.chemerys;

public interface Subscriber {

    void receiveMessage(String message);

    String getId();

}
