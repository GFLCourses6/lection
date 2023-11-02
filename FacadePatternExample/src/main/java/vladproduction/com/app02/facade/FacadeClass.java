package vladproduction.com.app02.facade;

import vladproduction.com.app02.singletons.SingletonA;
import vladproduction.com.app02.singletons.SingletonB;
import vladproduction.com.app02.singletons.SingletonC;

public class FacadeClass {

    public void createSingleton(){
        SingletonA.getInstance().doAction();
        SingletonB.getInstance().doAction();
        SingletonC.getInstance().doAction();
    }

}
