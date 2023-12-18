package com.vladproduction.dbApp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBServiceImpl implements DBService {

    private final Connection connection;

    public DBServiceImpl(Connection conn) {
        this.connection = conn;
    }

    @Override
    public ResultSet getAllBirds() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from birds");
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getFilteredBirds(String birdName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from birds where bird=?");
        ps.setString(1, birdName);
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    @Override
    public int insertBird(String birdName, String birdDescription) throws SQLException {
        PreparedStatement insertPS = connection.prepareStatement("insert into birds(bird, description) values (?, ?)");
        insertPS.setString(1, birdName);
        insertPS.setString(2, birdDescription);
        int executedUpdate = insertPS.executeUpdate();
        return executedUpdate;
    }

    @Override
    public int updateBird(String birdName, String birdDescription, int id) throws SQLException {
        PreparedStatement updateBird = connection.prepareStatement("update birds SET description = ? where bird = ? and id = ?;");
        updateBird.setString(1, birdDescription);
        updateBird.setString(2, birdName);
        updateBird.setInt(3, id);
        int updated = updateBird.executeUpdate();
        return updated;
    }

    @Override
    public int deleteBird(String birdName, int id) throws SQLException {
        PreparedStatement deleteBird = connection.prepareStatement("delete from birds where bird = ? and id = ?;");
        deleteBird.setString(1, birdName);
        deleteBird.setInt(2, id);
        int deleted = deleteBird.executeUpdate();
        return deleted;
    }
}
