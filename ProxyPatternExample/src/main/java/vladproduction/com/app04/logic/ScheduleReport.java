package vladproduction.com.app04.logic;

import vladproduction.com.app04.model.Train;
import vladproduction.com.app04.model.TrainSchedule;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ScheduleReport implements Schedule {

    public ScheduleReport(){
        loadingData();
    }

    @Override
    public void makeSchedule(LocalDate date) {

        System.out.println("Trains schedule complete (date; time): " + date +
                "; " + Time.valueOf(LocalTime.now()));
    }

    private void loadingData(){

        Train train1 = new Train("New-York");
        Train train2 = new Train("Chicago");
        Train train3 = new Train("Washington");

        List<Train> trainList = new ArrayList<>();
        trainList.add(train2);
        trainList.add(train3);
        trainList.add(train1);
        TrainSchedule trainSchedule = new TrainSchedule(trainList);
        List<Train> trains = trainSchedule.getTrains();
        System.out.println("\tTrains: ");
        for (Train train : trains) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("* " + train + " : arrived" + "\n");
        }
    }

}
