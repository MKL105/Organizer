package calendar;

import java.util.Date;

public class Task {
    private Date dueDate;
    private String name;
    private Duration duration;
    private boolean splittable;

    public Task(Date dueDate, String name, Duration duration, boolean splittable) {
        this.dueDate = dueDate;
        this.name = name;
        this.duration = duration;
        this.splittable = splittable;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isSplittable() {
        return splittable;
    }

    public void setSplittable(boolean splittable) {
        this.splittable = splittable;
    }

    @Override
    public String toString() {
        return "Task{" +
                "dueDate=" + dueDate +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", splittable=" + splittable +
                '}';
    }
}
