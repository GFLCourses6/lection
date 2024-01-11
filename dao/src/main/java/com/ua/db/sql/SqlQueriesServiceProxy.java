package com.ua.db.sql;

import java.util.HashMap;
import java.util.Map;

public class SqlQueriesServiceProxy
        implements SqlQueriesService {

    private final SqlQueriesService service;

    private static final Map<String, String> CACHE = new HashMap<>();

    public SqlQueriesServiceProxy(SqlQueriesService service) {
        this.service = service;
    }

    @Override
    public String constructSqlSearchUserById(String id) {

        System.out.println(id);

        String sql = CACHE.get(id);
        if (sql == null) {
            String userById = service.constructSqlSearchUserById(id);
            CACHE.put(id, userById);
            return userById;
        }
        return sql;
    }
}
