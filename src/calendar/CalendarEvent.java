package calendar;

/**
 * This abstract class represents a calendar event.
 *
 * @author Markus Luethje
 */

public abstract class CalendarEvent {

    protected String name;

    public CalendarEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void validate() throws Exception;
}
