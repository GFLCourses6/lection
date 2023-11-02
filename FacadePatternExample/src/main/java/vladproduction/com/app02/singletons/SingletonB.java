package vladproduction.com.app02.singletons;

public class SingletonB {

    private static SingletonB instance;

    private SingletonB() {

    }
    public void doAction(){
        System.out.println("Action 2: SingletonB");
    }

    public synchronized static SingletonB getInstance(){
        if(instance==null){
            instance = new SingletonB();
        }
        return instance;
    }
}
