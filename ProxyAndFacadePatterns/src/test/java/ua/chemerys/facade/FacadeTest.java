package ua.chemerys.facade;

import org.junit.Test;
import org.mockito.Mockito;
import ua.chemerys.service.DbConnectionService;
import ua.chemerys.service.DbConnectionServiceMySql;
import ua.chemerys.service.SQLQueriesService;
import ua.chemerys.service.SQLQueryServiceGeneric;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class FacadeTest {

    private static final String EXPECTED_RESULT = "Result of getting user by id SQL = SELECT * FROM user where id = justRandomId";

    private static final String ID = "justRandomId";

    @Test
    public void happyJUnit() {
        SQLQueriesService sqlQueriesService = new SQLQueryServiceGeneric();

        DbConnectionService dbConnectionService = new DbConnectionServiceMySql();

        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueriesService, dbConnectionService);
        String result = dbAccessService.getUserById(ID);

        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void happyMock() {
        SQLQueriesService sqlQueriesService = new SQLQueryServiceGeneric();
        //Mockito veeeeeeeery simplified RIGHT way to create complex object required for test
        DbConnectionService dbConnectionService = mock(DbConnectionService.class);
        Mockito.when(dbConnectionService
                .invokeSql(anyString()))
                .thenReturn("Result of getting user by id SQL = SELECT * FROM user where id = justRandomId");

        // Here is the end of complex object initialization
        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueriesService, dbConnectionService);

        String result = dbAccessService.getUserById(ID);

        assertEquals(EXPECTED_RESULT, result);

        verify(dbConnectionService, times(1)).invokeSql(eq("SELECT * FROM user where id = justRandomId"));
    }
}
