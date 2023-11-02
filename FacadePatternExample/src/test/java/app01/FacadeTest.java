package app01;

import org.junit.Test;
import vladproduction.com.app01.facade.DbAccessService;
import vladproduction.com.app01.facade.DbAccessServiceFacade;
import vladproduction.com.app01.service.DbConnectionService;
import vladproduction.com.app01.service.DbConnectionServiceImpl;
import vladproduction.com.app01.service.SQLService;
import vladproduction.com.app01.service.SQLServiceImpl;

import static junit.framework.TestCase.assertEquals;

public class FacadeTest {

    public static final String EXPECTED = "result of getting user by id sql = SELECT * FROM user where id = user-id";
    public static final String ID = "user-id";

    @Test
    public void positive(){

        SQLService sqlService = new SQLServiceImpl();
        DbConnectionService dbConnectionService = new DbConnectionServiceImpl();

        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlService, dbConnectionService);
        String result = dbAccessService.getUserById(ID);

        assertEquals(EXPECTED, result);

    }

}
