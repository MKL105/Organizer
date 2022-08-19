package ui;

import java.awt.*;

public class CalendarPanel extends Panel{

    final int WIDTH = 200;
    final int HEIGHT = 80;
    final Color BORDERCOLOR = Color.BLACK;
    final Color BACKGROUNDCOLOR = new Color(185, 185, 185);
    final int BORDERSTRENGTH = 2;

    public CalendarPanel() {
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackGround(g);
    }

    private void drawBackGround(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(BORDERCOLOR);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        graphic.setColor(BACKGROUNDCOLOR);
        graphic.fillRect(BORDERSTRENGTH, BORDERSTRENGTH, WIDTH - 2 * BORDERSTRENGTH, HEIGHT - 2 * BORDERSTRENGTH);
    }

    public void drawStringCentered(Graphics2D g, String str, int y, Color color) {
        g.setColor(color);
        int xPos = (WIDTH - g.getFontMetrics().stringWidth(str)) / 2;
        g.drawString(str, xPos, y);
    }
}
