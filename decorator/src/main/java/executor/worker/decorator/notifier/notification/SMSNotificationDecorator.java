package executor.worker.decorator.notifier.notification;

import executor.worker.decorator.notifier.BaseDecorator;
import executor.worker.decorator.notifier.Notifier;

public class SMSNotificationDecorator
        extends BaseDecorator {
    public SMSNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.printf("%s %s%n", this.getClass().getSimpleName(), message);
    }
}
