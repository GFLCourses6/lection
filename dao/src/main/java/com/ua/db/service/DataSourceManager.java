package com.ua.db.service;

import java.sql.Connection;

public interface DataSourceManager {
    Connection getConnection();
}
