package org.example.di;

import org.example.di.abstractFactory.AbstractFactory;
import org.example.di.abstractFactory.DIFactory;
import org.example.di.service.*;

public class AppDI {
    public static void main(String[] args) {
        // bad practice - new not effective, 'cause each time we need write new
//        StringIntegrationService service = new StringIntegrationServiceImpl();
//        service.parseStingByRegex("Alex;Lesha;Anton");

        AbstractFactory factory = new DIFactory(); // DI
        StringIntegrationService service = factory.create(StringIntegrationService.class); // IOC
        service.parseStingByRegex("Alex;Lesha;Anton");

        // singleton - so we ain't only create but and control life cycle
        FileIntegrationService fileIntegrationService = factory.create(FileIntegrationService.class);
        fileIntegrationService.getFileNameByPath("D:\\file.sql");

        // we ain't have real implementation
        //фабркиа на лету создает имплементацию интерфейса

        DBIntegrationService dbIntegrationService = factory.create(DBIntegrationService.class);
        dbIntegrationService.getUserById("555");
        dbIntegrationService.getUserById("3333");
        dbIntegrationService.getCityByRegion("Kyiv");
        dbIntegrationService.getCarByYear("2000");
        dbIntegrationService.getBookByYearAndAuthor("2000", "Alex");
    }
}
