package vladproduction.com.jackson_date;

import java.util.Date;
import java.util.Objects;

public class Event {

    private String eventTitle;
    private Date eventDate;

    public Event(String eventTitle, Date eventDate) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
    }

    public Event() {
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Event event = (Event) object;
        return Objects.equals(eventTitle, event.eventTitle) && Objects.equals(eventDate, event.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTitle, eventDate);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventTitle='" + eventTitle + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
