package ui;

import javax.swing.*;

public class Label extends JLabel {

    public Label(String text, String name) {
        super(text);
        this.setName(name);
    }
}
