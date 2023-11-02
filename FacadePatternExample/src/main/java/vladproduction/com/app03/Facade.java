package vladproduction.com.app03;

public class Facade {

    private final SystemStart systemStart;
    private final SystemDrive systemDrive;
    private final SystemStop systemStop;

    public Facade() {
        systemStart = new SystemStart();
        systemDrive = new SystemDrive();
        systemStop = new SystemStop();
    }

    public void operation(){
        systemStart.start();
        systemDrive.drive();
        systemStop.stop();
    }
}
