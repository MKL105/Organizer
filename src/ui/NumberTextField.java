package ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NumberTextField extends FormattedTextField{

    public NumberTextField() {
        super(new NumberFormatter(NumberFormat.getInstance()));
    }

    @Override
    protected InputVerifier getVerifier() {
        InputVerifier verifier = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JFormattedTextField field = (JFormattedTextField) input;
                String text = field.getText();
                return isValid(text);
            }

            @Override
            public boolean shouldYieldFocus(JComponent input) {
                boolean valid = verify(input);
                if (!valid) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid number");
                }
                return valid;
            }
        };
        return verifier;
    }

    @Override
    protected boolean isValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
