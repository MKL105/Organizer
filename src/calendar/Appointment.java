package calendar;

import java.awt.Color;
import java.util.Arrays;
import java.util.Date;

public class Appointment {
    private Date startDate;
    private Date endDate;
    private String name;
    private Person[] persons;
    private Location location;
    private boolean moveable;
    private Label label;
    private Color color;
    private RepetitionRule repetitionRule;

    public Appointment(Date startDate, Date endDate, String name, Person[] persons, Location location, boolean moveable, Label label, Color color, RepetitionRule repetitionRule) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.persons = persons;
        this.location = location;
        this.moveable = moveable;
        this.label = label;
        this.color = color;
        this.repetitionRule = repetitionRule;
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

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RepetitionRule getRepetitionRule() {
        return repetitionRule;
    }

    public void setRepetitionRule(RepetitionRule repetitionRule) {
        this.repetitionRule = repetitionRule;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", persons=" + Arrays.toString(persons) +
                ", location=" + location +
                ", moveable=" + moveable +
                ", label=" + label +
                ", color=" + color +
                ", repetitionRule=" + repetitionRule +
                '}';
    }
}
