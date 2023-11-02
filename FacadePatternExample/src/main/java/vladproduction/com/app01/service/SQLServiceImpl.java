package vladproduction.com.app01.service;

public class SQLServiceImpl implements SQLService {
    @Override
    public String constructSearcherUserById(String id) {

        String selectQuery = String.format("SELECT * FROM user where id = %s", id);
        System.out.println(selectQuery);
        return selectQuery;
    }
}
