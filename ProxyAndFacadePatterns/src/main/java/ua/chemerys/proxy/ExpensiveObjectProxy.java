package ua.chemerys.proxy;

import ua.chemerys.service.ExpensiveObject;
import ua.chemerys.service.ExpensiveObjectImpl;

public class ExpensiveObjectProxy implements ExpensiveObject {

    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}
