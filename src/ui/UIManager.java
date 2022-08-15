package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This class represents an UIManager that is the root responsible for everything UI-related.
 * @author Markus Luethje
 */

public class UIManager {

    final int MENUBUTTONWIDTH = 80;
    final int MENUBUTTONHEIGHT = 60;
    final int ADDBUTTONWIDTH = 150;
    final int ADDBUTTONHEIGHT = 60;
    final int HORIZONTALSPACINGWIDTH = 20;
    final int ADDBUTTONSSPACINGWIDTH = 20;
    final int ADDBUTTONSSPACINGMULTIPLIER = 4;
    final int CALENDARSPACINGWIDTH = 20;
    final Color BACKGROUNDCOLOR = new Color(151, 144, 236);


    public UIManager() {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = (JPanel) frame.getContentPane();

        BoxLayout boxLayoutHorizontal = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
        mainPanel.setLayout(boxLayoutHorizontal);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(BACKGROUNDCOLOR);

        Panel menuButtonPanel = new Panel();
        BoxLayout menuButtonLayout = new BoxLayout(menuButtonPanel, BoxLayout.Y_AXIS);
        menuButtonPanel.setLayout(menuButtonLayout);
        menuButtonPanel.setMaximumSize(new Dimension(MENUBUTTONWIDTH, Integer.MAX_VALUE));
        menuButtonPanel.setBackground(BACKGROUNDCOLOR);

        Panel addButtonsPanel = new Panel();
        BoxLayout addButtonsLayout = new BoxLayout(addButtonsPanel, BoxLayout.Y_AXIS);
        addButtonsPanel.setLayout(addButtonsLayout);
        addButtonsPanel.setMaximumSize(new Dimension(ADDBUTTONWIDTH, Integer.MAX_VALUE));
        addButtonsPanel.setBackground(BACKGROUNDCOLOR);

        Panel calendarAreaPanel = new Panel();
        BoxLayout calendarAreaLayout = new BoxLayout(calendarAreaPanel, BoxLayout.Y_AXIS);
        calendarAreaPanel.setLayout(calendarAreaLayout);
        calendarAreaPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        calendarAreaPanel.setBackground(BACKGROUNDCOLOR);


        UIButton menuButton = new UIButton("Menu", MENUBUTTONWIDTH, MENUBUTTONHEIGHT);
        UIButton addTaskButton = new UIButton("Add Task", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton addBlockerButton = new UIButton("Add Blocker", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton addAppointmentButton = new UIButton("Add Appointment", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton organizeButton = new UIButton("Organize", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton loadTemplateButton = new UIButton("Load Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton saveTemplateButton = new UIButton("Save Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);

        ScrollPane taskScrollPane = new ScrollPane();
        taskScrollPane.setPreferredSize(new Dimension(Integer.MAX_VALUE, 120));
        ScrollPane calendarScrollPane = new ScrollPane();
        calendarScrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        menuButtonPanel.add(menuButton);

        addButtonsPanel.add(addTaskButton);
        addButtonsPanel.add(Box.createRigidArea(new Dimension(0, ADDBUTTONSSPACINGWIDTH)));
        addButtonsPanel.add(addBlockerButton);
        addButtonsPanel.add(Box.createRigidArea(new Dimension(0, ADDBUTTONSSPACINGWIDTH)));
        addButtonsPanel.add(addAppointmentButton);
        addButtonsPanel.add(Box.createRigidArea(new Dimension(0, ADDBUTTONSSPACINGWIDTH * ADDBUTTONSSPACINGMULTIPLIER)));
        addButtonsPanel.add(organizeButton);
        addButtonsPanel.add(Box.createRigidArea(new Dimension(0, ADDBUTTONSSPACINGWIDTH * ADDBUTTONSSPACINGMULTIPLIER)));
        addButtonsPanel.add(loadTemplateButton);
        addButtonsPanel.add(Box.createRigidArea(new Dimension(0, ADDBUTTONSSPACINGWIDTH)));
        addButtonsPanel.add(saveTemplateButton);

        calendarAreaPanel.add(taskScrollPane);
        calendarAreaPanel.add(Box.createRigidArea(new Dimension(0, CALENDARSPACINGWIDTH)));
        calendarAreaPanel.add(calendarScrollPane);

        mainPanel.add(menuButtonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(HORIZONTALSPACINGWIDTH, 0)));
        mainPanel.add(addButtonsPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(HORIZONTALSPACINGWIDTH, 0)));
        mainPanel.add(calendarAreaPanel);

        frame.setVisible(true);
    }
}
