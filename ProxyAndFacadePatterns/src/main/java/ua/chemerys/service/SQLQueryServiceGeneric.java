package ua.chemerys.service;

public class SQLQueryServiceGeneric implements SQLQueriesService{
    @Override
    public String constructSqlSearchUserById(String id) {
        String sql = String.format("SELECT * FROM user where id = %s", id);
        System.out.println(sql);
        return sql;
    }
}
