package org.example.facade.service;

import org.example.facade.service.DbConnectionService;

public class DBConnectionServiceMySQL implements DbConnectionService {
    @Override
    public String invokeSQL(String sql) {
        System.out.println("Setup connection, get connection from pool, invoke sql");

        return "result of getting user by id sql = " + sql;
    }
}
