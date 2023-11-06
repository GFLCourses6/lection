package pattern.singleton;

public class SingletonApp {
  public static void main(String[] args) {

    Singleton singleton = Singleton.getInstance("Hello, Singleton!");

    System.out.println("Value from Singleton: " + singleton.getValue());

    Singleton anotherSingleton = Singleton.getInstance("Another Value");
    System.out.println("Value from Another Singleton: " + anotherSingleton.getValue());

    System.out.println("Are they the same instance? " + (singleton == anotherSingleton));
  }
}

