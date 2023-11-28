package com.vladproduction.factory;

import com.vladproduction.services.DBIntegrationService;
import com.vladproduction.services.FileIntegrationService;
import com.vladproduction.services.StringIntegrationService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractFactoryTest {

    @Test
    public void dBIntegrationServiceTest() {

        AbstractFactory af = new AbstractFactoryImpl();
        DBIntegrationService dbIntegrationService = af.create(DBIntegrationService.class);
        String userByIdResult = dbIntegrationService.getUserById("7");
        assertEquals(userByIdResult, "SELECT * FROM user WHERE id = '7'");

        String bookByYear = dbIntegrationService.getBookByYear("2023");
        assertEquals(bookByYear, "SELECT * FROM book WHERE year = '2023'");

        String byYearAndAuthor = dbIntegrationService.getBookByYearAndAuthor("2023", "John Doe");
        assertEquals(byYearAndAuthor.toLowerCase(), "SELECT * FROM book WHERE year = '2023' AND author = 'John Doe'".toLowerCase());
    }

    @Test
    public void fileIntegrationServiceTest() {
        AbstractFactory af = new AbstractFactoryImpl();
        FileIntegrationService fileIntegrationService = af.create(FileIntegrationService.class);
        String fileNameByPath = fileIntegrationService.getFileNameByPath(".");
        assertEquals(fileNameByPath, ".");

        //is Singleton
        FileIntegrationService fileIntegrationService2 = af.create(FileIntegrationService.class);
        assertEquals(fileIntegrationService.hashCode(), fileIntegrationService2.hashCode());
        assertEquals(fileIntegrationService, fileIntegrationService2);

        assertTrue(fileIntegrationService == fileIntegrationService2);
    }

    @Test
    public void stringIntegrationServiceTest() {
        AbstractFactory af = new AbstractFactoryImpl();
        StringIntegrationService stringIntegrationService = af.create(StringIntegrationService.class);
        String parsedRes = stringIntegrationService.parsStringByRegex("one;two;three");
        assertEquals(parsedRes, "onetwothree");

        //is not singleton
        StringIntegrationService stringIntegrationService2 = af.create(StringIntegrationService.class);
        assertNotEquals(stringIntegrationService.hashCode(), stringIntegrationService2.hashCode());
        assertNotEquals(stringIntegrationService, stringIntegrationService2);

        assertFalse(stringIntegrationService == stringIntegrationService2);
    }
}
