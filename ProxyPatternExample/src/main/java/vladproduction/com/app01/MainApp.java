package vladproduction.com.app01;

public class MainApp {
    public static void main(String[] args) {

        Vocabulary vocabulary = new WordProxy(new Word());
        System.out.println(vocabulary.getWord("Car"));
        System.out.println(vocabulary.getWord("Dog"));
        System.out.println(vocabulary.getWord("Cat"));
        System.out.println(vocabulary.getWord("Dog"));

    }
}
