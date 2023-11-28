package org.example.facade.service;

public class SQLQueriesServiceGeneric implements SQLQueriesService{

    @Override
    public String constructSQLSearchById(String id) {
        String sql = String.format("SELECT * FRO user where id = %s", id);
        System.out.println(sql);
        return sql;
    }
}
