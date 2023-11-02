package vladproduction.com.app04.main;

import vladproduction.com.app04.logic.Schedule;
import vladproduction.com.app04.logic.ScheduleReport;
import vladproduction.com.app04.logic.ScheduleReportProxy;

import java.time.LocalDate;

public class MainApp04 {
    public static void main(String[] args) {

        ScheduleReport report = new ScheduleReport();
        report.makeSchedule(LocalDate.now());

        Schedule trainReportProxy = new ScheduleReportProxy(report);
        trainReportProxy.makeSchedule(LocalDate.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trainReportProxy.makeSchedule(LocalDate.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trainReportProxy.makeSchedule(LocalDate.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trainReportProxy.makeSchedule(LocalDate.now());

    }
}
