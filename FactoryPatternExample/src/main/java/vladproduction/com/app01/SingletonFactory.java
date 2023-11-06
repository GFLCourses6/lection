package vladproduction.com.app01;

public class SingletonFactory {

    public static Singleton produce(int x) {

        if (x == 1) {
            return SingletonA.getInstance();
        } else {
            return SingletonB.getInstance();
        }

    }

}
