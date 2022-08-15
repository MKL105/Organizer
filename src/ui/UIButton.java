package ui;

import javax.swing.*;
import java.awt.*;

public class UIButton extends JButton {

    public UIButton(String name, int maxWidth, int maxHeight) {
        super(name);
        this.setMaximumSize(new Dimension(maxWidth, maxHeight));
    }
}
