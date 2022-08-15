package calendar;

import java.awt.Color;
import java.util.Arrays;
import java.util.Date;

/**
 * This class represents an appointment with specified additional information.
 * @author Markus Luethje
 */

public class Appointment extends CalendarEvent {
    private Person[] persons;
    private Location location;
    private Label label;
    private Color color;
    private RepetitionRule repetitionRule;

    public Appointment(String name, Date startDate, Date endDate, Person[] persons, Location location, boolean moveable, Label label, Color color, RepetitionRule repetitionRule) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
        this.location = location;
        this.moveable = moveable;
        this.label = label;
        this.color = color;
        this.repetitionRule = repetitionRule;
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
}
