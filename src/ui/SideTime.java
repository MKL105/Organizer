package ui;

import calendar.Duration;

public class SideTime {

    final int startHours;
    final int startMinutes;
    private int endHours;
    private int endMinutes;

    public SideTime(int startHours, int startMinutes, Duration duration) {
        this.startHours = startHours;
        this.startMinutes = startMinutes;
        this.endHours = startHours + duration.getHours();
        this.endMinutes = startMinutes + duration.getMinutes();
        optimize();
    }

    public void optimize() {
        int addEndHours = endMinutes / 60;
        endMinutes = endMinutes - (addEndHours * 60);
        endHours += addEndHours;
    }

    public int getStartHours() {
        return startHours;
    }

    public int getStartMinutes() {
        return startMinutes;
    }

    public int getEndHours() {
        return endHours;
    }

    public int getEndMinutes() {
        return endMinutes;
    }

    public String startTimeToString() {
        String ret = "";
        ret += (startHours < 10) ? ("0" + startHours) : String.valueOf(startHours);
        ret += ":";
        ret += (startMinutes < 10) ? ("0" + startMinutes) : String.valueOf(startMinutes);
        return ret;
    }

    public String endTimeToString() {
        String ret = "";
        ret += (endHours < 10) ? ("0" + endHours) : String.valueOf(endHours);
        ret += ":";
        ret += (endMinutes < 10) ? ("0" + endMinutes) : String.valueOf(endMinutes);
        return ret;
    }
}
