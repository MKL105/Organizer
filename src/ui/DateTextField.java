package ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTextField extends FormattedTextField {

    public DateTextField(String name) {
        super(new DateFormatter(new SimpleDateFormat("dd.MM.yyyy")), name);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
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
                            "Please enter a valid date in format dd.mm.yyyy");
                }
                return valid;
            }
        };
        return verifier;
    }

    @Override
    protected boolean isValid(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(dateString);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
}
