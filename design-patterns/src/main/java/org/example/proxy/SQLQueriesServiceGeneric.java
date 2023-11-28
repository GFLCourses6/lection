package org.example.proxy;

public class SQLQueriesServiceGeneric implements SQLQueryService{
    @Override
    public String constructSQLSearchUserByID(String id) {
        String sql = String.format("SELECT * FROM user where id = %s", id);
        System.out.println(sql);
        return sql;
    }
}
