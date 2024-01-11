package executor.worker.decorator.notifier.notification;

import executor.worker.decorator.notifier.BaseNotifier;
import executor.worker.decorator.notifier.Notifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class NotificationDecoratorTest {

    private Notifier baseNotifier;
    private Notifier notifier;

    @BeforeEach
    public void setup() {
        baseNotifier = mock(BaseNotifier.class);
        notifier = new MailNotificationDecorator(baseNotifier);
    }

    @Test
    void testMailNotifications() {
        notifier.send("Alert");
        verify(baseNotifier, times(1)).send("Alert");
    }

    @Test
    void testNotification() {

        Notifier decoratedNotifier =
                new SlackNotificationDecorator(
                        new MailNotificationDecorator(
                                new SMSNotificationDecorator(
                                        baseNotifier)));
        decoratedNotifier.send("Alert");
        verify(baseNotifier).send("Alert");
        verify(baseNotifier, times(1)).send("Alert");
    }
    @Test
     void testMailNotification() {
        Notifier decoratedNotifier = new MailNotificationDecorator(baseNotifier);
        decoratedNotifier.send("Alert");
        verify(baseNotifier, times(1)).send("Alert");
    }

    @Test
    void testSlackNotification() {
        Notifier decoratedNotifier = new SlackNotificationDecorator(baseNotifier);
        decoratedNotifier.send("Alert");
        verify(baseNotifier, times(1)).send("Alert");
    }

    @Test
    void testSMSNotification() {
        Notifier decoratedNotifier = new SMSNotificationDecorator(baseNotifier);
        decoratedNotifier.send("Alert");
        verify(baseNotifier, times(1)).send("Alert");
    }
}