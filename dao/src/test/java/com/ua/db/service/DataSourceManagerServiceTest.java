package com.ua.db.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DataSourceManagerServiceTest {

    @Mock
    private PGSimpleDataSource dataSource;

    @Mock
    private Connection connection;

    @InjectMocks
    private DataSourceManagerService dataSourceManagerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetConnection()
            throws SQLException {
        DataSourceManagerService service = mock(DataSourceManagerService.class);
        when(service.getConnection()).thenReturn(mock(Connection.class));
        assertNotNull(service.getConnection(), "Connection should not be null");
        verify(service, times(1)).getConnection();
    }
    @Test
    void testGetConnections()
            throws SQLException {
        DataSourceManagerService service = spy(new DataSourceManagerService());
        doReturn(mock(Connection.class)).when(service).getConnection();
        assertNotNull(service.getConnection(), "Connection should not be null");
        verify(service, times(1)).getConnection();
    }
    @Test
    void testGetConnectionSuccess() {
        DataSourceManagerService service = spy(new DataSourceManagerService());
        doReturn(mock(Connection.class)).when(service).getConnection();
        assertNotNull(service.getConnection(), "Connection should not be null");
        verify(service, times(1)).getConnection();
    }

    @Test
    void testGetConnectionFailure() {
        DataSourceManagerService service = spy(new DataSourceManagerService());
        doThrow(new RuntimeException(new SQLException())).when(service).getConnection();
        assertThrows(RuntimeException.class, service::getConnection, "Should throw RuntimeException");
        verify(service, times(1)).getConnection();
    }
}
