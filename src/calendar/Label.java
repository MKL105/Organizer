package calendar;

import java.awt.Color;

public class Label {
    private String name;
    private Color color;

    public Label(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
