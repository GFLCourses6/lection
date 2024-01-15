package ua.chemerys;

public class Singleton {

    private static Singleton instance;

    private String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Singleton getInstance(String value) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
