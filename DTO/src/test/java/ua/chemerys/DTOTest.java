package ua.chemerys;

import org.junit.Test;
import ua.chemerys.model.Login;
import ua.chemerys.model.MadLogin;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Junit tests for simple DTO
 */
public class DTOTest {

    @Test
    public void shouldAnswerWithTrue() {

        //Chapter I

        System.out.println("************************");
        System.out.println("Chapter I");
        System.out.println("************************");


        Login login1 = new Login();
        login1.setUsername("Hanna");
        login1.setPassword("test password");
        login1.setTimestamp(9L);

        Login login2 = new Login();
        login2.setUsername("Hanna");
        login2.setPassword("test password");
        login2.setTimestamp(9L);

        if (login1 == login2) {
            System.out.println("both logins ==");
        }
        if (login1.equals(login2)) {
            System.out.println("both logins equals");
        }

        //Equals override test block
        assertEquals(login1, login2);

        //Bad practice
//        assertEquals(login1.getUsername(), login2.getUsername());
//        assertEquals(login1.getPassword(), login2.getPassword());
//        assertEquals(login1.getTimestamp(), login2.getTimestamp());

        login2.setUsername("Annie");

        assertNotEquals(login1, login2);

        //Chapter II

        System.out.println("************************");
        System.out.println("Chapter II");
        System.out.println("************************");

        String successStatus = "SUCCESS";
        String failedStatus = "FAILED";

        //Hashcode override test block
        Map<Login, String> loginsAndStatuses = new HashMap<>();

        login2.setUsername("Hanna");

        loginsAndStatuses.put(login1, successStatus);
        loginsAndStatuses.put(login2, failedStatus);
        System.out.println("Map size: " + loginsAndStatuses.size());
        System.out.println("Hash code login1 = " + login1.hashCode());
        System.out.println("Hash code login2 = " + login2.hashCode());

        assertEquals(failedStatus, loginsAndStatuses.get(login1));

        System.out.println("Status: " + failedStatus);
        System.out.println("Value from Map: " + loginsAndStatuses.get(login1));

        //Chapter III

        System.out.println("************************");
        System.out.println("Chapter III");
        System.out.println("************************");

        MadLogin madLogin1 = new MadLogin();
        madLogin1.username = "BadGuy";
        madLogin1.password = "test password";
        madLogin1.timeStamp = 10L;

        MadLogin madLogin2 = new MadLogin();
        madLogin2.username = "BadGuy";
        madLogin2.password = "test password";
        madLogin2.timeStamp = 10L;

        Map<MadLogin, String> madLoginsAndStatuses = new HashMap<>();
        madLoginsAndStatuses.put(madLogin1, successStatus);
        madLoginsAndStatuses.put(madLogin2, failedStatus);
        System.out.println("Map size: " + madLoginsAndStatuses.size());

        System.out.println("Hash code madLogin1 = " + madLogin1.hashCode());
        System.out.println("Hash code madLogin2 = " + madLogin2.hashCode());

        //Is that expected behavior?
        assertNotEquals(failedStatus, madLoginsAndStatuses.get(madLogin1));
        assertEquals(successStatus, madLoginsAndStatuses.get(madLogin1));
    }
}
