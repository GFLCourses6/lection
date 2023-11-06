package vladproduction.com.app03;

public class Sport implements Car{

    @Override
    public void assemble() {
        System.out.println("Sport type Car assembling:");
        System.out.println("\t-powerful engine; -high speed ability");
        //could be some specific for sport type production functions;
    }
}
