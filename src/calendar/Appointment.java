package calendar;

import Exceptions.InvalidTimeSpanStartEndException;

import java.util.Date;

/**
 * This class represents an appointment, a fixed event that takes place at a certain time.
 *
 * @author Markus Luethje
 */

public class Appointment extends CalendarEvent {

    final Date startDate;
    final Date endDate;
    final RepetitionRule repetitionRule;

    public Appointment(String name, Date startDate, Date endDate, RepetitionRule repetitionRule) {
        super(name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.repetitionRule = repetitionRule;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public RepetitionRule getRepetitionRule() {
        return repetitionRule;
    }

    @Override
    public void validate() throws InvalidTimeSpanStartEndException {
        if (endDate.before(startDate)) {
            throw new InvalidTimeSpanStartEndException("End of appointment cannot be earlier than start!");
        }
    }
}
