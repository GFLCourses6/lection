package com.vladproduction.dbApp.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBService {
    //CRUD
    ResultSet getAllBirds() throws SQLException;
    ResultSet getFilteredBirds(String birdName) throws SQLException;
    int insertBird(String birdName, String birdDescription) throws SQLException;
    int updateBird(String birdName, String birdDescription, int id) throws SQLException;
    int deleteBird(String birdName, int id) throws SQLException;
}
