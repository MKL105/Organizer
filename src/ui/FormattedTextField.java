package ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatter;

public abstract class FormattedTextField extends JFormattedTextField{

    public FormattedTextField(DefaultFormatter formatter) {
        super(formatter);
    }

    protected abstract InputVerifier getVerifier();
    protected abstract boolean isValid(String input);
}
