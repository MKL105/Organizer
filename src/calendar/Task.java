package calendar;

import Exceptions.DurationLongerThanProcessingTimeException;
import Exceptions.InvalidTimeSpanStartEndException;
import Exceptions.NegativeDurationDataException;

import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a task.
 *
 * @author Markus Luethje
 */

public class Task extends CalendarEvent{
    final Duration duration;
    final boolean splittable;
    final Date timeSpanStart;
    final Date timeSpanEnd;

    public Task(String name, Duration duration, boolean splittable, Date timeSpanStart, Date timeSpanEnd) {
        super(name);
        this.duration = duration;
        this.splittable = splittable;
        this.timeSpanStart = timeSpanStart;
        this.timeSpanEnd = timeSpanEnd;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isSplittable() {
        return splittable;
    }

    public Date getTimeSpanStart() {
        return timeSpanStart;
    }

    public Date getTimeSpanEnd() {
        return timeSpanEnd;
    }

    public void validate() throws NegativeDurationDataException, InvalidTimeSpanStartEndException, DurationLongerThanProcessingTimeException {
        if (timeSpanEnd.before(timeSpanStart)) {
            throw new InvalidTimeSpanStartEndException("Processing period end cannot be earlier than start!");
        }

        Calendar c1 = Calendar.getInstance();
        c1.setTime(timeSpanStart);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(timeSpanEnd);
        int timeSpanDays = (int) java.time.Duration.between(c1.toInstant(), c2.toInstant()).toDays();
        int timeSpanHours = java.time.Duration.between(c1.toInstant(), c2.toInstant()).toHoursPart();
        int timeSpanMinutes = java.time.Duration.between(c1.toInstant(), c2.toInstant()).toMinutesPart();

        try {
            Duration spanDur = new Duration(timeSpanDays, timeSpanHours, timeSpanMinutes);
            if (spanDur.compareTo(duration) < 0) {
                throw new DurationLongerThanProcessingTimeException("Duration cannot be longer than processing time!");
            }
        } catch (NegativeDurationDataException e) {
            throw new NegativeDurationDataException("An error has occurred!\n" +
                    "Please try again and make sure to enter valid input data.");
        } catch (DurationLongerThanProcessingTimeException e) {
            throw e;
        }
    }
}
