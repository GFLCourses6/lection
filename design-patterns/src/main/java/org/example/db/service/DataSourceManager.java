package org.example.db.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataSourceManager {
    Connection getConnection() throws SQLException;
}
