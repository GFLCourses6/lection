package vladproduction.com.app03;

public class MainApp03 {
    public static void main(String[] args) {

//        HeavyObject heavyObject = new HeavyObjectImpl();
//        heavyObject.process();
        /*  Loading init config...
            Load complete!  */

        HeavyObject heavyObject = new ProxyHeavyObjectImpl();
        heavyObject.process();
        heavyObject.process();
        heavyObject.process();
        heavyObject.process();

        System.out.println("-----------2-----------");
        HeavyObject heavyObject2 = new ProxyHeavyObjectImpl();
        heavyObject2.process();
        heavyObject2.process();
    }
}
