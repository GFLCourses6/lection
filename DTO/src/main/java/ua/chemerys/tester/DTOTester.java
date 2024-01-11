package ua.chemerys.tester;

import ua.chemerys.model.LoginImmutable;
import ua.chemerys.model.LoginMutable;

public class DTOTester {

    public static void main(String[] args) {

        LoginMutable loginMutable = new LoginMutable();
        loginMutable.setUsername("Hanna");

        //Expected print Hanna
        System.out.println("Execute getUsername() method: " + loginMutable.getUsername());

        loginMutable.setUsername("Annie");

        //Expected print Annie
        System.out.println("Execute getUsername() method: " + loginMutable.getUsername());

        System.out.println("-----------------------");

        LoginImmutable loginImmutable = new LoginImmutable("Hanna Immutable", "my test password", 9L);

        //Expected print Hanna Immutable, which is not possible to change within application, as set method doesn't exist
        System.out.println("Execute getUsername() method: " + loginImmutable.getUsername());
    }
}
