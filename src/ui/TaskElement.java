package ui;

import calendar.Task;

import javax.swing.*;
import java.awt.*;

public class TaskElement extends Panel {

    final Task task;
    final Color TASKFILLCOLOR = new Color(213, 70, 70);
    final Color TASKBORDERCOLOR = new Color(218, 15, 15);
    final Color TEXTCOLOR = Color.WHITE;
    final Color BACKGROUNDCOLOR = new Color(255, 168, 139);
    final int WIDTH = 100;
    final int HEIGHT = 120;
    final int BORDERSTRENGTH = 3;
    final int ARCWITHHEIGHT = 10;
    final int SPACING = 15;

    public TaskElement(Task task) {
        this.task = task;
        this.setMaximumSize(new Dimension(WIDTH + SPACING, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH + SPACING, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        int offset = SPACING / 2;
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(TASKBORDERCOLOR);
        graphic.fillRoundRect(offset, 0, WIDTH, HEIGHT, ARCWITHHEIGHT, ARCWITHHEIGHT);
        graphic.setColor(TASKFILLCOLOR);
        graphic.fillRoundRect(BORDERSTRENGTH + offset, BORDERSTRENGTH, WIDTH - (2 * BORDERSTRENGTH), HEIGHT - (2 * BORDERSTRENGTH), ARCWITHHEIGHT, ARCWITHHEIGHT);
        drawStringCentered(graphic, task.getName(), 20);
    }

    private void drawStringCentered(Graphics2D graphic, String str, int y) {
        graphic.setColor(TEXTCOLOR);
        int xPos = (WIDTH / 2) - (graphic.getFontMetrics().stringWidth(str) / 2);
        graphic.drawString(str, xPos, y);
    }

}
