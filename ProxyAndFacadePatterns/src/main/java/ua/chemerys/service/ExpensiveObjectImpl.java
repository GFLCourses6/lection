package ua.chemerys.service;

public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }
    @Override
    public void process() {

        System.out.println("Just imagine that processing complete");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Let's imagine again... Loading initial configuration...");
    }
}
