package com.classwork.pattern.proxy.service.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqlQueriesServiceGeneric
        implements SqlQueriesService {

    private static final Logger LOGGER = LogManager.getLogger(SqlQueriesServiceGeneric.class);

    @Override
    public String constructSqlSearchUserById(String id) {
        LOGGER.info(id);
        return String.format("SELECT * FROM user WHERE id = %s", id);
    }
}
