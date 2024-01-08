package org.example.db;

import org.example.db.service.DBService;
import org.example.db.service.DBServiceImpl;
import org.example.db.service.DataSourceManager;
import org.example.db.service.DataSourceManagerImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        DataSourceManager dataSourceManager = new DataSourceManagerImpl();
        Connection connection = dataSourceManager.getConnection();
        DBService service = new DBServiceImpl(connection);

        ResultSet rs = service.getAllBirds();
        while (rs.next()) {
            System.out.println(String.format("All birds: id: %d bird: %s description: %s%n",
                    rs.getLong("id"),
                    rs.getString("bird"),
                    rs.getString("description")));
        }

        ResultSet rsFiltered = service.getFilteredBirds("eagle");
        while (rsFiltered.next()) {
            System.out.println(String.format("Filtered birds: id: %d bird: %s description: %s%n",
                    rsFiltered.getLong("id"),
                    rsFiltered.getString("bird"),
                    rsFiltered.getString("description")));
        }

        try {
            int insertedRows = service.insertBird("rooster", "wakes you up in the morning");
            System.out.println(String.format("inserted %s bird(s)%n", insertedRows));
        } catch (SQLException e) {
            String errorCode = e.getSQLState();
            if (errorCode == "08000") {

            } else if (errorCode == "42601") {
                throw e;
            } else {
                System.out.println(String.format("SQL failed with error code: %s%n", errorCode));
            }
        }
        int updatedRows = service.updateBird("rooster2", "has a red crown");
        System.out.println(String.format("updated %s bird(s)%n", updatedRows));
        int deletedRows = service.deleteBird("rooster1");
        System.out.println(String.format("deleted %s bird(s)%n", deletedRows));

        rs = service.getAllBirds();
        while (rs.next()){
            System.out.println(String.format("All birds: id:%s description: %s%n",
                    rs.getLong("id"),
                    rs.getString("bird"),
                    rs.getString("description")));
        }
    }
}
