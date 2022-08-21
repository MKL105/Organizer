package ui;

import javax.swing.*;

public class TextField extends JTextField {

    public TextField(String text, String name) {
        super(text);
        this.setName(name);
    }
}
