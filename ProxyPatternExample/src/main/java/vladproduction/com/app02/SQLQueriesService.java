package vladproduction.com.app02;

public class SQLQueriesService implements SQLService {

    @Override
    public String searchUserById(String id) {
        String searchQuery = String.format("SELECT * FROM user where id = %s", id);
        System.out.println(searchQuery);
        return searchQuery;
    }
}
