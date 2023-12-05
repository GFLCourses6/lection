package com.ua.db.service;

import java.sql.SQLException;
import java.util.List;

public interface CrudDBService<T>
        extends AutoCloseable {

    List<T> getAllBirds()
            throws SQLException;

    List<T> getFilterBirds(String name)
            throws SQLException;

    int insertBird(
            String name,
            String description)
            throws SQLException;

    int updateBird(
            String name,
            String description)
            throws SQLException;

    int deleteBird(String name)
            throws SQLException;
}
