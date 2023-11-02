package vladproduction.com.app02.singletons;

public class SingletonC {

    private static SingletonC instance;

    private SingletonC() {
    }

    public void doAction(){
        System.out.println("Action 3: SingletonC");
    }

    public synchronized static SingletonC getInstance(){
        if(instance==null){
            instance = new SingletonC();
        }
        return instance;
    }
}
