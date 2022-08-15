package calendar;

public class Duration {
    private int days;
    private int hours;
    private int minutes;

    public Duration(int days, int hours, int minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "days=" + days +
                ", hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
