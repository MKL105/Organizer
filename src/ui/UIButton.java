package ui;

import javax.swing.*;
import java.awt.*;

public class UIButton extends JButton {

    public UIButton(String text, int maxWidth, int maxHeight, boolean force, String name) {
        super(text);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
        if (force) {
            this.setPreferredSize(new Dimension(maxWidth, maxHeight));
        }
        this.setName(name);
    }

    public UIButton(String text, int maxWidth, int maxHeight, int fontSize, String name) {
        super(text);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
        Font font = this.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), fontSize);
        this.setFont(newFont);
        this.setName(name);
    }

    public UIButton(String text, String name) {
        super(text);
        this.setName(name);
    }
}
