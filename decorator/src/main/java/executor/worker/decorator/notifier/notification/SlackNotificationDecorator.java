package executor.worker.decorator.notifier.notification;

import executor.worker.decorator.notifier.BaseDecorator;
import executor.worker.decorator.notifier.Notifier;

public class SlackNotificationDecorator
        extends BaseDecorator {
    public SlackNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendToSlack(message);
    }

    private void sendToSlack(String message) {
        System.out.printf("%s %s%n", this.getClass().getSimpleName(), message);
    }
}
