package ui;

import calendar.SideTime;

import java.awt.*;

public class CalendarBorderSidePanel extends CalendarPanel {

    final SideTime time;
    final Color TEXTCOLOR = new Color(0, 170, 169);

    public CalendarBorderSidePanel(SideTime time) {
        this.time = time;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        String str = time.startTimeToString() + " - " + time.endTimeToString();
        Graphics2D graphic = (Graphics2D) g;
        drawStringCentered(graphic, str, 20, TEXTCOLOR);
    }
}
