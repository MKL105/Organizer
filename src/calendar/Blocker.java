package calendar;

import java.util.Date;

/**
 * This class represents a blocker.
 * @author Markus Luethje
 */

public class Blocker extends CalendarEvent{

    private Interval interval;

    public Blocker(String name, Date startDate, Date endDate, Interval interval) {
        super(name, startDate, endDate, false);
        this.interval = interval;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }
}
