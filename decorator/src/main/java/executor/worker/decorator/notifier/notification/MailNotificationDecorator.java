package executor.worker.decorator.notifier.notification;

import executor.worker.decorator.notifier.BaseDecorator;
import executor.worker.decorator.notifier.Notifier;

public class MailNotificationDecorator
        extends BaseDecorator {
    public MailNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendToMail(message);
    }

    private void sendToMail(String message) {
        System.out.printf("%s %s%n", this.getClass().getSimpleName(), message);
    }
}
