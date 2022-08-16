package calendar;

import java.util.Date;

public class Interval {

    private Date intervalStart;
    private Date intervalEnd;

    public Interval(Date intervalStart, Date intervalEnd) {
        this.intervalStart = intervalStart;
        this.intervalEnd = intervalEnd;
    }

    public Date getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(Date intervalStart) {
        this.intervalStart = intervalStart;
    }

    public Date getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(Date intervalEnd) {
        this.intervalEnd = intervalEnd;
    }
}
