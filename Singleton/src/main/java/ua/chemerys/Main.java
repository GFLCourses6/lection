package ua.chemerys;

public class Main {
    public static void main(String[] args) {

        Thread firstThread = new Thread(new FirstThread());
        Thread secondThread = new Thread(new SecondThread());

        firstThread.start();
        secondThread.start();

    }

    static class FirstThread implements Runnable {
        @Override
        public void run() {

            Singleton testCase1 = Singleton.getInstance("Test");
            System.out.println(testCase1.getValue());
        }
    }

    static class SecondThread implements Runnable {
        @Override
        public void run() {
            Singleton testCase2 = Singleton.getInstance("It's just joke. This is Singleton. " +
                    "Think again about what will be printed");

            System.out.println(testCase2.getValue());
        }
    }
}