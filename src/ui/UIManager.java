package ui;

import javax.swing.*;

/**
 * This class represents an UIManager that is the root responsible for everything UI-related.
 * @author Markus Luethje
 */

public class UIManager {
    public UIManager() {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
