package vladproduction.com.app01;

public class SingletonB implements Singleton{

    private static SingletonB instance;

    private SingletonB() {
    }

    public static SingletonB getInstance(){
        if(instance == null){
            instance = new SingletonB();
        }
        return instance;
    }

    @Override
    public void createSingleton() {
        System.out.println("SingletonB created");

    }
}
