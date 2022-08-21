package ui;

import javax.swing.*;

public class CheckBox extends JCheckBox {

    public CheckBox(String text, String name) {
        super(text);
        this.setName(name);
    }
}
