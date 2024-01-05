package com.ua.db.service;

import com.ua.db.model.BirdRecord;

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
        implements CrudDBService<BirdRecord> {

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
    public List<BirdRecord> getAllBirds()
            throws SQLException {
        List<BirdRecord> birdRecordNames = new ArrayList<>();
        try (ResultSet resultSet = connection
                .prepareStatement(SELECT_ALL)
                .executeQuery()) {
            mapToList(resultSet, birdRecordNames);
        }
        return birdRecordNames;
    }

    private static void mapToList(
            ResultSet resultSet,
            List<BirdRecord> birdRecords)
            throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("bird");
            String description = resultSet.getString("description");
            birdRecords.add(new BirdRecord(id, name, description));
        }
    }


    @Override
    public List<BirdRecord> getFilterBirds(String name)
            throws SQLException {
        List<BirdRecord> filteredBirdRecords = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            mapToList(resultSet, filteredBirdRecords);
        }
        return filteredBirdRecords;
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
