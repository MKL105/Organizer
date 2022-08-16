package main;

import calendar.Duration;
import calendar.Task;
import ui.UIManager;

import java.util.Date;

/**
 * This class represents the main Organizer.
 *
 * @author Markus Luethje
 */

public class Organizer {

    public static void main(String[] args) {
        UIManager uiManager = new UIManager();
        Task testTask2 = new Task("Test", new Date(2022, 8, 16, 18, 0), new Duration(0, 3, 0), false, null);
    }
}
