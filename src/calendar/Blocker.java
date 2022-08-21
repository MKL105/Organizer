package calendar;

import java.util.Date;

/**
 * This class represents a blocker. A blocker reserves a certain amount of time in a certain timespan.
 *
 * @author Markus Luethje
 */

public class Blocker extends CalendarEvent{

    final Duration duration;
    final boolean splittable;
    final Date timeSpanStart;
    final Date timeSpanEnd;
    final RepetitionRule repetitionRule;

    public Blocker(String name, Duration duration, boolean splittable, Date timeSpanStart, Date timeSpanEnd, RepetitionRule repetitionRule) {
        super(name);
        this.duration = duration;
        this.splittable = splittable;
        this.timeSpanStart = timeSpanStart;
        this.timeSpanEnd = timeSpanEnd;
        this.repetitionRule = repetitionRule;
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

    public RepetitionRule getRepetitionRule() {
        return repetitionRule;
    }

    @Override
    public void validate() throws Exception {

    }
}
