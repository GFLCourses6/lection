package com.ua.db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ua.db.service.Query.DELETE;
import static com.ua.db.service.Query.INSERT;
import static com.ua.db.service.Query.SELECT_ALL;
import static com.ua.db.service.Query.SELECT_BY;
import static com.ua.db.service.Query.UPDATE;

public class BirdCrudDBService
        implements CrudDBService<Bird> {

    private final Connection connection;

    public BirdCrudDBService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close()
            throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public List<Bird> getAllBirds()
            throws SQLException {
        List<Bird> birdNames = new ArrayList<>();
        try (ResultSet resultSet = connection
                .prepareStatement(SELECT_ALL)
                .executeQuery()) {
            mapToList(resultSet, birdNames);
        }
        return birdNames;
    }

    private static void mapToList(
            ResultSet resultSet,
            List<Bird> birds)
            throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("bird");
            String description = resultSet.getString("description");
            birds.add(new Bird(id, name, description));
        }
    }


    @Override
    public List<Bird> getFilterBirds(String name)
            throws SQLException {
        List<Bird> filteredBirds = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            mapToList(resultSet, filteredBirds);
        }
        return filteredBirds;
    }

    @Override
    public int insertBird(
            String name,
            String description)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, name);
            statement.setString(2, description);
            return statement.executeUpdate();
        }
    }

    @Override
    public int updateBird(
            String name,
            String description)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, description);
            statement.setString(2, name);
            return statement.executeUpdate();
        }
    }

    @Override
    public int deleteBird(String name)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setString(1, name);
            return statement.executeUpdate();
        }
    }
}
