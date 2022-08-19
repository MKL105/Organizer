package ui;

import javax.swing.*;
import java.awt.*;

public class UIButton extends JButton {

    public UIButton(String name, int maxWidth, int maxHeight) {
        super(name);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
    }

    public UIButton(String name, int maxWidth, int maxHeight, boolean force) {
        super(name);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
        this.setPreferredSize(new Dimension(maxWidth, maxHeight));
    }

    public UIButton(String name, int maxWidth, int maxHeight, int fontSize) {
        super(name);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
        Font font = this.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), fontSize);
        this.setFont(newFont);
    }

    public UIButton(String name) {
        super(name);
    }
}
