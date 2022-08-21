package ui;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;

public abstract class FormattedTextField extends JFormattedTextField{

    public FormattedTextField(DefaultFormatter formatter, String name) {
        super(formatter);
        this.setName(name);
    }

    protected abstract InputVerifier getVerifier();
    protected abstract boolean isValid(String input);
}
