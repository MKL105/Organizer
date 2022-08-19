package calendar;

/**
 * This class holds the internal representation of an event duration.
 */

public class Duration {
    private int days;
    private int hours;
    private int minutes;

    public Duration(int days, int hours, int minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
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

    public void setDays(int days) {
        this.days = days;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        String ret = "";
        if (getDays() > 0) {
            ret += getDays() + "D";
        }
        if (getHours() > 0) {
            ret += getHours() + "H";
        }
        if (getMinutes() > 0) {
            ret += getMinutes() + "M";
        }
        return ret;
    }

    private void optimizeDur() {
        int addhours = getMinutes() / 60;
        setMinutes(getMinutes() - (addhours * 60));
        setHours(getHours() + addhours);
        int addDays = getHours() / 24;
        setHours(getHours() - (addDays * 24));
        setDays(getDays() + addDays);
    }
}
