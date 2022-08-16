package ui;

import calendar.Duration;
import calendar.Task;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * This class represents an UIManager that is the root responsible for everything UI-related.
 * @author Markus Luethje
 */

public class UIManager {

    final Panel mainPanel;
    final Panel menuButtonPanel;
    final Panel addButtonsPanel;
    final Panel calendarAreaPanel;
    final Panel taskScrollPanel;
    final Panel calendarScrollPanel;
    final ScrollPane taskScrollPane;
    final ScrollPane calendarScrollPane;
    final UIButton addTaskButton;
    final Frame frame;
    final int MENUBUTTONWIDTH = 80;
    final int MENUBUTTONHEIGHT = 60;
    final int ADDBUTTONWIDTH = 150;
    final int ADDBUTTONHEIGHT = 60;
    final int HORIZONTALSPACINGWIDTH = 20;
    final int ADDBUTTONSSPACINGWIDTH = 20;
    final int ADDBUTTONSSPACINGMULTIPLIER = 4;
    final int CALENDARSPACINGWIDTH = 20;
    final Color BACKGROUNDCOLOR = new Color(151, 144, 236);
    private int taskCount = 0;


    public UIManager() {
        frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        mainPanel = new Panel();

        BoxLayout boxLayoutHorizontal = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
        mainPanel.setLayout(boxLayoutHorizontal);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(BACKGROUNDCOLOR);

        menuButtonPanel = new Panel();
        BoxLayout menuButtonLayout = new BoxLayout(menuButtonPanel, BoxLayout.Y_AXIS);
        menuButtonPanel.setLayout(menuButtonLayout);
        menuButtonPanel.setMaximumSize(new Dimension(MENUBUTTONWIDTH, Integer.MAX_VALUE));
        menuButtonPanel.setBackground(BACKGROUNDCOLOR);

        addButtonsPanel = new Panel();
        BoxLayout addButtonsLayout = new BoxLayout(addButtonsPanel, BoxLayout.Y_AXIS);
        addButtonsPanel.setLayout(addButtonsLayout);
        addButtonsPanel.setMaximumSize(new Dimension(ADDBUTTONWIDTH, Integer.MAX_VALUE));
        addButtonsPanel.setBackground(BACKGROUNDCOLOR);

        calendarAreaPanel = new Panel();
        BoxLayout calendarAreaLayout = new BoxLayout(calendarAreaPanel, BoxLayout.Y_AXIS);
        calendarAreaPanel.setLayout(calendarAreaLayout);
        calendarAreaPanel.setBackground(BACKGROUNDCOLOR);

        taskScrollPanel = new Panel();
        taskScrollPanel.setLayout(new BoxLayout(taskScrollPanel, BoxLayout.X_AXIS));

        calendarScrollPanel = new Panel();

        UIButton menuButton = new UIButton("Menu", MENUBUTTONWIDTH, MENUBUTTONHEIGHT);
        addTaskButton = new UIButton("Add Task", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        addTaskButton.addActionListener(e -> {
            Task testTask = new Task("Test", new Date(2022, 8, 16, 18, 0), new Duration(0, 3, 0), false, null);
            addNewTask(testTask);
        });
        UIButton addBlockerButton = new UIButton("Add Blocker", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton addAppointmentButton = new UIButton("Add Appointment", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton organizeButton = new UIButton("Organize", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton loadTemplateButton = new UIButton("Load Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);
        UIButton saveTemplateButton = new UIButton("Save Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT);

        taskScrollPane = new ScrollPane(taskScrollPanel);
        taskScrollPane.getViewport().setPreferredSize(new Dimension(Integer.MAX_VALUE, 120));
        taskScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        taskScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        calendarScrollPane = new ScrollPane(calendarScrollPanel);
        calendarScrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        calendarScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        calendarScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

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

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void addNewTask(Task task) {
        TaskElement te = new TaskElement(task);
        taskScrollPanel.add(te);
        taskScrollPanel.revalidate();
    }
}
