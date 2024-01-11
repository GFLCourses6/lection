package com.ua.db.sql;

public class SqlQueriesServiceGeneric
        implements SqlQueriesService {

    @Override
    public String constructSqlSearchUserById(String id) {
        return String.format("SELECT * FROM user WHERE id = %s", id);
    }
}
