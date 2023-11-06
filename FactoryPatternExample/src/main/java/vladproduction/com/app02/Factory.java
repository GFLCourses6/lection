package vladproduction.com.app02;

public class Factory {

    public static Product create(String x){

        if(x.equalsIgnoreCase("A")){
            return new ProductA();
        }
        if(x.equalsIgnoreCase("B")){
            return new ProductB();
        }
        return null;
    }
}
