package vladproduction.com.app03;

public class SUV implements Car{

    @Override
    public void assemble() {
        System.out.println("SUV type Car assembling:");
        System.out.println("\t-powerful engine; -high cross-country ability");
        //could be some specific for SUV type production functions;
    }
}
