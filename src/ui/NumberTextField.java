package ui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class NumberTextField extends FormattedTextField{

    public NumberTextField(String name) {
        super(new NumberFormatter(NumberFormat.getInstance()), name);
    }

    @Override
    protected InputVerifier getVerifier() {
        return new InputVerifier() {
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
