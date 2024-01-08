package org.example.db.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBService {
    ResultSet getAllBirds() throws SQLException;
    ResultSet getFilteredBirds(String birdname) throws SQLException;
    int insertBird(String birdName, String birdDescription) throws SQLException;
    int updateBird(String birdName, String birdDescription) throws SQLException;
    int deleteBird(String birdName) throws SQLException;
}
