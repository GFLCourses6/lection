package vladproduction.com.app04.logic;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ScheduleReportProxy implements Schedule{

    private Schedule realObject;
    private static final Map<LocalDate, Schedule> cache = new HashMap<>();

    public ScheduleReportProxy(Schedule realObject){
        this.realObject = realObject;
    }

    @Override
    public void makeSchedule(LocalDate date) {
        if(realObject == null){
            realObject = new ScheduleReport();
            Schedule put = cache.put(date, realObject);
            System.out.println(put);
        }
        realObject.makeSchedule(date);
        Schedule scheduleReport = cache.get(date);
        if(scheduleReport != null){
            System.out.println(scheduleReport);
        }

    }
}
