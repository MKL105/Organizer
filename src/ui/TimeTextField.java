package ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTextField extends FormattedTextField{

    public TimeTextField() {
        super(new DateFormatter(new SimpleDateFormat("hh:mm")));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        LocalDateTime now = LocalDateTime.now();
        this.setText(dtf.format(now));
        this.setInputVerifier(getVerifier());
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
                            "Please enter a valid time in format hh:mm");
                }
                return valid;
            }
        };
        return verifier;
    }

    @Override
    protected boolean isValid(String timeString) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        try {
            format.parse(timeString);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
}
