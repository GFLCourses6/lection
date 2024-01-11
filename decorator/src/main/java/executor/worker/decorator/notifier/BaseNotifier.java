package executor.worker.decorator.notifier;

public class BaseNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.printf("%s %s%n", this.getClass().getSimpleName(), message);
    }
}