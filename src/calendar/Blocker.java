package calendar;

import java.util.Date;

public class Blocker {
    private Date startDate;
    private Date endDate;
    private String name;

    public Blocker(Date startDate, Date endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Blocker{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                '}';
    }
}
