package executor.worker.decorator.notifier;

public abstract class BaseDecorator
        implements Notifier {
    private final Notifier notifier;

    protected BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}
