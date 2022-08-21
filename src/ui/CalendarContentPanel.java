package ui;

import calendar.CalendarEvent;

import java.awt.*;

public class CalendarContentPanel extends Panel {

    final CalendarEvent event;
    final Color BACKGROUNDCOLOR;
    final Color BORDERCOLOR = Color.BLACK;
    final Color TEXTCOLOR;
    final int WIDTH;
    final int HEIGHT;
    final int BORDERSTRENGTH = 2;

    public CalendarContentPanel(CalendarEvent event, int width, int height, Color color) {
        super("calendarContentPanel");
        this.event = event;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        BACKGROUNDCOLOR = color;
        TEXTCOLOR = new Color((255 - BACKGROUNDCOLOR.getRed()), (255 - BACKGROUNDCOLOR.getGreen()), (255 - BACKGROUNDCOLOR.getBlue()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(BORDERCOLOR);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        graphic.setColor(BACKGROUNDCOLOR);
        graphic.fillRect(BORDERSTRENGTH, BORDERSTRENGTH, WIDTH - 2 * BORDERSTRENGTH, HEIGHT - 2 * BORDERSTRENGTH);
        drawStringCentered(graphic, event.getName(), (HEIGHT - graphic.getFontMetrics().getHeight()) / 2, TEXTCOLOR);
    }

    private void drawStringCentered(Graphics2D g, String str, int y, Color color) {
        g.setColor(color);
        int xPos = (WIDTH - g.getFontMetrics().stringWidth(str)) / 2;
        g.drawString(str, xPos, y);
    }
}
