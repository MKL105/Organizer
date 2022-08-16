package calendar;

/**
 * This abstract class represents a calendar event.
 * @author Markus Luethje
 */

import java.util.Date;

public abstract class CalendarEvent {
    protected String name;
    protected Date startDate;
    protected Date endDate;
    protected boolean moveable;

    public CalendarEvent(String name, Date startDate, Date endDate, boolean moveable) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.moveable = moveable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }
}
