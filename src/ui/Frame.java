package ui;

import javax.swing.JFrame;

/**
 * This class represents the Frame that is needed in order to have a graphical user interface.
 * @author Markus Luethje
 */

public class Frame extends JFrame {
    public Frame(String name) {
        super("Organizer");
        this.setName(name);
    }

}
