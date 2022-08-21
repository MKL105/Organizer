package ui;

import java.awt.*;

public class CalendarBorderSidePanel extends CalendarPanel {

    final SideTime time;
    final Color TEXTCOLOR = new Color(0, 170, 169);

    public CalendarBorderSidePanel(SideTime time, int width, int height) {
        super(width, height);
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
        drawStringCentered(graphic, str, (HEIGHT + g.getFontMetrics().getHeight()) / 2, TEXTCOLOR);
    }
}
