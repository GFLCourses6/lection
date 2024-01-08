package org.example.db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBServiceImpl implements DBService{
    private final Connection connection;

    public DBServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet getAllBirds() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from birds");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    @Override
    public ResultSet getFilteredBirds(String birdname) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from birds where bird=?");
        statement.setString(1, birdname);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    @Override
    public int insertBird(String birdName, String birdDescription) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO birds(bird, description) VALUES(?, ?)");
        statement.setString(1, birdName);
        statement.setString(2, birdDescription);
        int insertedRows = statement.executeUpdate();
        return insertedRows;
    }

    @Override
    public int updateBird(String birdName, String birdDescription) throws SQLException {
        PreparedStatement updatedStatement = connection.prepareStatement("UPDATE birds SET description = ? where bird = ?");
        updatedStatement.setString(1, birdDescription);
        updatedStatement.setString(2, birdName);
        int insertedRows = updatedStatement.executeUpdate();
        return insertedRows;
    }

    @Override
    public int deleteBird(String birdName) throws SQLException {
        PreparedStatement deletedStatement = connection.prepareStatement("DELETE FROM birds where bird = ?");
        deletedStatement.setString(1, birdName);
        int deletedRows = deletedStatement.executeUpdate();
        return deletedRows;
    }
}
