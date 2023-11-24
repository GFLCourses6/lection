package com.gfl.prokhnov.di;

import com.gfl.prokhnov.di.factory.AbstractFactory;
import com.gfl.prokhnov.di.factory.DIFactory;
import com.gfl.prokhnov.di.service.DbIntegrationService;
import com.gfl.prokhnov.di.service.FileIntegrationService;
import com.gfl.prokhnov.di.service.StringIntegrationService;
import com.gfl.prokhnov.di.service.StringIntegrationServiceImpl;

public class DiApp {
    public static void main(String[] args) {

        // bad practice
/*        StringIntegrationService stringIntegrationService = new StringIntegrationServiceImpl();
        stringIntegrationService.parseStringByRegex("1;2;3");*/

        AbstractFactory abstractFactory = new DIFactory();

        StringIntegrationService stringIntegrationService = abstractFactory.create(StringIntegrationService.class);
        stringIntegrationService.parseStringByRegex("1;2;3");

        FileIntegrationService fileIntegrationService = abstractFactory.create(FileIntegrationService.class);
        fileIntegrationService.getFileNameByPath("D:\\test.sql");

        DbIntegrationService dbIntegrationService = abstractFactory.create(DbIntegrationService.class);
        dbIntegrationService.getUserById("13");
        dbIntegrationService.getCityByCapital("Kyiv");

    }
}
