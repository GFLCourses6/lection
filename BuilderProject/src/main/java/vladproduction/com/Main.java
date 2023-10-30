package vladproduction.com;

public class Main {
    public static void main(String[] args) {

//        User.Builder builder = new User.Builder();
//        builder.setLogin("Login1");
//        User user = new User(builder);
//        System.out.println("user = " + user);

        //return this:
        User.Builder builder = new User.Builder().setLogin("Login2").setPassword("123").setTimestamp(20L);
        User user = new User(builder);
        System.out.println("user = " + user);

        User user2 = new User.Builder().setLogin("Login3").setPassword("456").setTimestamp(30L).build();

        User user3 = new User.Builder().setLogin("Login3").setTimestamp(30L).build();
    }
}
