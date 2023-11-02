package vladproduction.com.app03;

public class ProxyHeavyObjectImpl implements HeavyObject{

    private static HeavyObject object;
    @Override
    public void process() {
        if(object == null){
            object = new HeavyObjectImpl();
        }
        object.process();

    }
}
