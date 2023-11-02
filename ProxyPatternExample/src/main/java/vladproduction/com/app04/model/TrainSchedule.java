package vladproduction.com.app04.model;


import java.util.List;

public class TrainSchedule {

    private final List<Train> trains;

    public TrainSchedule(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }

}
