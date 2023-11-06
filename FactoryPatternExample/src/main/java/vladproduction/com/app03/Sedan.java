package vladproduction.com.app03;

public class Sedan implements Car{

    @Override
    public void assemble() {
        System.out.println("Sedan type Car assembling:");
        System.out.println("\t-economy engine; -high comfort ability");
        //could be some specific for sedan type production functions;
    }
}
