package calendar;

import java.util.Date;

/**
 * This class represents a blocker.
 * @author Markus Luethje
 */

public class Blocker extends CalendarEvent{

    private Interval interval;
    private Duration duration;

    public Blocker(String name, Interval interval, Duration duration) {
        super(name, interval.getIntervalStart(), interval.getIntervalEnd(), false);
        this.interval = interval;
        this.duration = duration;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
