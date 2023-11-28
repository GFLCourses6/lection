package com.vladproduction.main;

import com.vladproduction.factory.AbstractFactory;
import com.vladproduction.factory.AbstractFactoryImpl;
import com.vladproduction.services.DBIntegrationService;
import com.vladproduction.services.FileIntegrationService;
import com.vladproduction.services.StringIntegrationService;

public class MainApp {
    public static void main(String[] args) {
        //not good practice if create instance directly:
        /*StringIntegrationService stringIntegration = new StringIntegrationServiceImpl();
        stringIntegration.parsStringByRegex("John;Artur;Jack");*/

        //----------factory:
        //good approach:
        AbstractFactory factory = new AbstractFactoryImpl(); //once we create factory and use it as far

        //----------stringService:
        //next step: InversionOfControl principle
        System.out.println("//----------stringService:");
        StringIntegrationService stringIntegrationService = factory.create(StringIntegrationService.class);
        stringIntegrationService.parsStringByRegex("John;Artur;Jack");

        //----------fileService:
        System.out.println("//----------fileService:");
        FileIntegrationService fileIntegrationService = factory.create(FileIntegrationService.class);
        //fileIntegrationService.getFileNameByPath("absolute path file");
        fileIntegrationService.getFileNameByPath(".");

        //----------dbService:
        System.out.println("//----------dbService:");
        DBIntegrationService dbIntegrationService = factory.create(DBIntegrationService.class);
        dbIntegrationService.getUserById("7");
        dbIntegrationService.getUserById("5");
        dbIntegrationService.getCityByRegion("London");
        dbIntegrationService.getBookByYear("2020");
        dbIntegrationService.getBookByYearAndAuthor("2023", "John");
        dbIntegrationService.getBookByYearOrAuthor("2021", "Jack");



    }
}
