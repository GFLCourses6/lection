package vladproduction.com.app02.singletons;

public class SingletonA {

    private static SingletonA instance;

    private SingletonA() {

    }

    public void doAction(){
        System.out.println("Action 1: SingletonA");
    }

    public synchronized static SingletonA getInstance(){
        if(instance==null){
            instance = new SingletonA();
        }
        return instance;
    }
}
