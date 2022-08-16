package calendar;

import java.util.Date;

/**
 * This class represents a task.
 * @author Markus Luethje
 */

public class Task extends CalendarEvent{
    private Date dueDate;
    private Duration duration;
    private boolean splittable;
    private Interval interval;

    public Task(String name, Date dueDate, Duration duration, boolean splittable, Interval interval) {
        super(name, null, null, false);
        this.dueDate = dueDate;
        this.duration = duration;
        this.splittable = splittable;
        this.interval = interval;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isSplittable() {
        return splittable;
    }

    public void setSplittable(boolean splittable) {
        this.splittable = splittable;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }
}
