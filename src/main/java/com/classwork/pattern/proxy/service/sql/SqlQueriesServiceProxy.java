package com.classwork.pattern.proxy.service.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SqlQueriesServiceProxy
        implements SqlQueriesService {

    private static final Logger LOGGER = LogManager.getLogger(SqlQueriesServiceProxy.class);

    private final SqlQueriesService service;

    private static final Map<String, String> CACHE = new HashMap<>();

    public SqlQueriesServiceProxy(SqlQueriesService service) {
        this.service = service;
    }

    @Override
    public String constructSqlSearchUserById(String id) {

        LOGGER.info(id);

        String sql = CACHE.get(id);
        if (sql == null) {
            String userById = service.constructSqlSearchUserById(id);
            CACHE.put(id, userById);
            return userById;
        }
        return sql;
    }
}
