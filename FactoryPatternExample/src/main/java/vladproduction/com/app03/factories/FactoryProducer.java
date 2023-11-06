package vladproduction.com.app03.factories;

public class FactoryProducer {

    public static Factory getFactory(int type){
        switch (type){
            case 0: return new SedanFactory();
            case 1: return new SportFactory();
            case 2: return new SUVFactory();
            default: throw new IllegalArgumentException("set correct type");
        }
    }
}
