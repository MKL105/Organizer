package calendar;

import java.util.Date;

/**
 * This class represents a blocker.
 * @author Markus Luethje
 */

public class Blocker extends CalendarEvent{

    public Blocker(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.moveable = false;
    }
}
