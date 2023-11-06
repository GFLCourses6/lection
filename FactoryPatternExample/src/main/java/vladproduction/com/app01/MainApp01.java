package vladproduction.com.app01;

import java.util.Scanner;

public class MainApp01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter '1' to create SingletonA or other number for SingletonB : ");
        int type = Integer.parseInt(scanner.nextLine());

        Singleton singleton = SingletonFactory.produce(type);
        singleton.createSingleton();

        scanner.close();
    }
}
