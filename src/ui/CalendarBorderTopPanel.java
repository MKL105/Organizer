package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class CalendarBorderTopPanel extends CalendarPanel {

    final Color TEXTCOLOR = new Color(0, 170, 169);
    final Calendar calendar;

    public CalendarBorderTopPanel(Date date) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        drawStringCentered(graphic, getDateString(), 20, TEXTCOLOR);
        drawStringCentered(graphic, getWeekday(), 35, TEXTCOLOR);
    }

    private String getDateString() {
        return getDayFormatted(calendar.get(Calendar.DAY_OF_MONTH)) + "." +
                getMonthFormatted(calendar.get(Calendar.MONTH)) + "." + calendar.get(Calendar.YEAR);
    }

    private String getWeekday() {
        return switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "";
        };
    }

    private String getDayFormatted(int day) {
        return (day < 10) ? ("0" + day) : String.valueOf(day);
    }

    private String getMonthFormatted(int month) {
        ++month;
        return (month < 10) ? ("0" + month) : String.valueOf(month);
    }
}
