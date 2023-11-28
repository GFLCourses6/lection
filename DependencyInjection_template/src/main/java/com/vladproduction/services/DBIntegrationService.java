package com.vladproduction.services;

public interface DBIntegrationService {

    //select * from user where id = '20'
    String getUserById(String id);

    //select * from city where region = 'Kiev'
    String getCityByRegion(String name);

    //select * from book where year = '2020'
    String getBookByYear(String year);

    //select * from book where year = '2023' and author = 'John'
    String getBookByYearAndAuthor(String year, String author);

    //select * from book where year = '2023' or author = 'John'
    String getBookByYearOrAuthor(String year, String author);
}
