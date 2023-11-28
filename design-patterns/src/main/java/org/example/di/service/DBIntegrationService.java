package org.example.di.service;

public interface DBIntegrationService {
    // select * from user where id = '33'
    String getUserById(String id);
    // select * from city where region = 'Lviv'
    String getCityByRegion(String name);
    // select * from car where year = '2000'
    String getCarByYear(String year);
    // select * from book where year = '1991' and author = 'alex'
    String getBookByYearAndAuthor(String year, String author);

}
