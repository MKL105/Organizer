package ui;

import calendar.Blocker;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BlockerElement extends Panel{

    final Blocker blocker;
    final Color BLOCKERFILLCOLOR = new Color(243, 184, 6);
    final Color BLOCKERBORDERCOLOR = new Color(144, 179, 46);
    final Color TEXTCOLOR = Color.BLACK;
    final int WIDTH = 100;
    final int HEIGHT = 120;
    final int BORDERSTRENGTH = 3;
    final int ARCWIDTHHEIGHT = 10;
    final int SPACING = 15;
    final int LEFTALLIGN = (SPACING/2) + BORDERSTRENGTH + 5;

    public BlockerElement(Blocker blocker) {
        super("blockerElement");
        this.blocker = blocker;
        this.setMaximumSize(new Dimension(WIDTH + SPACING, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH + SPACING, HEIGHT));
        this.setLayout(new BorderLayout());
        Panel bottomPanel = new Panel("bottomPanel");
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(0, 0, 0, 0));
        this.add(bottomPanel, BorderLayout.PAGE_END);
        UIButton infoButton = new UIButton("Info", 40, 40, 10, "infoButton");
        bottomPanel.add(infoButton, BorderLayout.LINE_END);
        bottomPanel.setBorder(new EmptyBorder(BORDERSTRENGTH * 2, SPACING, BORDERSTRENGTH * 2, SPACING));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        int offset = SPACING / 2;
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(BLOCKERBORDERCOLOR);
        graphic.fillRoundRect(offset, 0, WIDTH, HEIGHT, ARCWIDTHHEIGHT, ARCWIDTHHEIGHT);
        graphic.setColor(BLOCKERFILLCOLOR);
        graphic.fillRoundRect(BORDERSTRENGTH + offset, BORDERSTRENGTH, WIDTH - (2 * BORDERSTRENGTH), HEIGHT - (2 * BORDERSTRENGTH), ARCWIDTHHEIGHT, ARCWIDTHHEIGHT);
        drawBlockerName(graphic, blocker.getName());
        drawInfo(graphic);
    }

    private void drawBlockerName(Graphics2D graphic, String name) {
        String firstStr = name;
        String secondStr = "";
        int index = name.length() - 2;

        while (graphic.getFontMetrics().stringWidth(firstStr) > (WIDTH - BORDERSTRENGTH - 10)) {
            firstStr = name.substring(0, index);
            secondStr = name.substring(index);
            --index;
        }
        index = secondStr.length() - 2;

        if (graphic.getFontMetrics().stringWidth(secondStr) > (WIDTH - BORDERSTRENGTH - 10)) {
            while (graphic.getFontMetrics().stringWidth(secondStr + "...") > (WIDTH - BORDERSTRENGTH - 10)) {
                secondStr = secondStr.substring(0, index);
                --index;
            }
            secondStr += "...";
        }

        drawStringCentered(graphic, firstStr, 15);
        drawStringCentered(graphic, secondStr, 15 + graphic.getFontMetrics().getHeight());
    }

    private void drawInfo(Graphics2D g) {
        String duration = "Dur: " + blocker.getDuration().toString();
        drawString(g, duration, 55);
    }

    private void drawStringCentered(Graphics2D graphic, String str, int y) {
        graphic.setColor(TEXTCOLOR);
        int xPos = (WIDTH + SPACING - graphic.getFontMetrics().stringWidth(str)) / 2;
        graphic.drawString(str, xPos, y);
    }

    private void drawString(Graphics2D g, String str, int y) {
        g.setColor(TEXTCOLOR);
        g.drawString(str, LEFTALLIGN, y);
    }
}
