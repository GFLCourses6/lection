package vladproduction.com.app03;

public class HeavyObjectImpl implements HeavyObject {

    public HeavyObjectImpl() {
        heavyInitConfig();
    }

    @Override
    public void process() {
        System.out.println("Load complete!");

    }

    private void heavyInitConfig() {
        System.out.println("Loading init config..."); //something what goes slow
    }
}
