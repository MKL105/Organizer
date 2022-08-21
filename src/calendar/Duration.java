package calendar;

import Exceptions.NegativeDurationDataException;

/**
 * This class holds the internal representation of an event duration.
 *
 * @author Markus Luethje
 */

public class Duration implements Comparable<Duration> {
    private int days;
    private int hours;
    private int minutes;

    public Duration(int days, int hours, int minutes) throws NegativeDurationDataException {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        validateInputData();
        optimizeDur();
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        String ret = "";
        if (days > 0) {
            ret += days + "D";
        }
        if (hours > 0) {
            ret += hours + "H";
        }
        if (minutes > 0) {
            ret += minutes + "M";
        }
        return ret;
    }

    private void optimizeDur() {
        int addHours = minutes / 60;
        minutes -= addHours * 60;
        hours += addHours;
        int addDays = hours / 24;
        hours -= addDays * 24;
        days += addDays;
    }

    @Override
    public int compareTo(Duration d) {
        if ((this.days == d.getDays()) && (this.hours == d.getHours()) && (this.minutes == d.getMinutes())) {
            return 0;
        } else if (this.days > d.getDays()) {
            return 1;
        } else if (this.days < d.getDays()) {
            return -1;
        } else if (this.hours > d.getHours()) {
            return 1;
        } else if (this.hours < d.getHours()) {
            return -1;
        } else if (this.minutes > d.getMinutes()) {
            return 1;
        } else {
            return -1;
        }
    }

    private void validateInputData() throws NegativeDurationDataException {
        if (days < 0) {
            throw new NegativeDurationDataException("Negative days entered for duration!");
        }
        if (hours < 0) {
            throw new NegativeDurationDataException("Negative hours entered for duration!");
        }
        if (minutes < 0) {
            throw new NegativeDurationDataException("Negative minutes entered for duration!");
        }
    }
}
