package com.vladproduction.dbApp;

import com.vladproduction.dbApp.service.DBService;
import com.vladproduction.dbApp.service.DBServiceImpl;
import com.vladproduction.dbApp.service.DataSourceManager;
import com.vladproduction.dbApp.service.DataSourceManagerImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws Exception{

        DataSourceManager dataSourceManager = new DataSourceManagerImpl();
        Connection connection = dataSourceManager.getConnection();
        DBService dbService = new DBServiceImpl(connection);

        ResultSet rs = dbService.getAllBirds();
        System.out.println("---All birds:---" );
        while (rs.next()){
            System.out.printf("\tid: %d, bird: %s, description: %s%n",
                    rs.getInt("id"), rs.getString("bird"), rs.getString("description"));
        }

        ResultSet rsFiltered = dbService.getFilteredBirds("eagle");
        System.out.println("---Filtered:---");
        while (rsFiltered.next()){
            System.out.printf("Selected bird: id: %d, bird: %s, description: %s%n",
                    rsFiltered.getInt("id"),
                    rsFiltered.getString("bird"),
                    rsFiltered.getString("description"));
        }

        System.out.println("---Inserted:---");
        try {
            int insertBird = dbService.insertBird("flamingo", "pink color");
            System.out.printf("InsertedBird: %s bird(s)%n", insertBird);
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("---Updated:---");
        int updateBird = dbService.updateBird("chicken", "home bird", 6);
        System.out.printf("UpdatedBird: %s bird(s)%n", updateBird);

        System.out.println("---Deleted:---");
        int deleteBird = dbService.deleteBird("chicken",  9);
        System.out.printf("DeletedBird: %s bird(s)%n", deleteBird);


    }
}
