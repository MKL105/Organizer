package ui;

import Exceptions.DurationLongerThanProcessingTimeException;
import Exceptions.InvalidTimeSpanStartEndException;
import Exceptions.NegativeDurationDataException;
import calendar.*;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * This class represents an UIManager that is the root responsible for everything UI-related.
 *
 * @author Markus Luethje
 */

public class UIManager {

    final Panel taskScrollPanel;
    final Panel calendarScrollPanel;
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

    final int TOPROWWIDTH = 200;
    final int TOPROWHEIGHT = 80;
    final int SIDEROWWIDTH = 100;
    final int SIDEROWHEIGHT = 40;

    public UIManager() throws NegativeDurationDataException {
        frame = new Frame("mainFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Panel mainPanel = new Panel("mainPanel");

        BoxLayout boxLayoutHorizontal = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
        mainPanel.setLayout(boxLayoutHorizontal);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(BACKGROUNDCOLOR);

        Panel menuButtonPanel = new Panel("menuButtonPanel");
        BoxLayout menuButtonLayout = new BoxLayout(menuButtonPanel, BoxLayout.Y_AXIS);
        menuButtonPanel.setLayout(menuButtonLayout);
        menuButtonPanel.setMaximumSize(new Dimension(MENUBUTTONWIDTH, Integer.MAX_VALUE));
        menuButtonPanel.setBackground(BACKGROUNDCOLOR);

        Panel addButtonsPanel = new Panel("addButtonsPanel");
        BoxLayout addButtonsLayout = new BoxLayout(addButtonsPanel, BoxLayout.Y_AXIS);
        addButtonsPanel.setLayout(addButtonsLayout);
        addButtonsPanel.setMaximumSize(new Dimension(ADDBUTTONWIDTH, Integer.MAX_VALUE));
        addButtonsPanel.setBackground(BACKGROUNDCOLOR);

        Panel calendarAreaPanel = new Panel("calendarAreaPanel");
        BoxLayout calendarAreaLayout = new BoxLayout(calendarAreaPanel, BoxLayout.Y_AXIS);
        calendarAreaPanel.setLayout(calendarAreaLayout);
        calendarAreaPanel.setBackground(BACKGROUNDCOLOR);

        taskScrollPanel = new Panel("taskScrollPanel");
        taskScrollPanel.setLayout(new BoxLayout(taskScrollPanel, BoxLayout.X_AXIS));

        calendarScrollPanel = new Panel(new GridBagLayout(), "calendarScrollPanel");
        setUpCalendar();

        UIButton menuButton = new UIButton("Menu", MENUBUTTONWIDTH, MENUBUTTONHEIGHT, false, "menuButton");
        UIButton addTaskButton = new UIButton("Add Task", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "addTaskButton");
        addTaskButton.addActionListener(e -> newTaskInput());
        UIButton addBlockerButton = new UIButton("Add Blocker", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "addBlockerButton");
        addBlockerButton.addActionListener(e -> newBlockerInput());
        UIButton addAppointmentButton = new UIButton("Add Appointment", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "addAppointmentButton");
        addAppointmentButton.addActionListener(e -> newAppointmentInput());
        UIButton organizeButton = new UIButton("Organize", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "organizeButton");
        UIButton loadTemplateButton = new UIButton("Load Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "loadTemplateButton");
        UIButton saveTemplateButton = new UIButton("Save Template", ADDBUTTONWIDTH, ADDBUTTONHEIGHT, false, "saveTemplateButton");

        ScrollPane taskScrollPane = new ScrollPane(taskScrollPanel);
        taskScrollPane.getViewport().setPreferredSize(new Dimension(Integer.MAX_VALUE, 120));
        taskScrollPane.getViewport().setMinimumSize(new Dimension(Integer.MAX_VALUE, 120));
        taskScrollPane.getViewport().setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        taskScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        taskScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        ScrollPane calendarScrollPane = new ScrollPane(calendarScrollPanel);
        //Note: the following line is a workaround since setting Integer.MAX_VALUE as the height doesn't work
        calendarScrollPane.getViewport().setPreferredSize(new Dimension(Integer.MAX_VALUE, 100000));
        calendarScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        calendarScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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

    public void addNewBlocker(Blocker blocker) {
        BlockerElement be = new BlockerElement(blocker);
        taskScrollPanel.add(be);
        taskScrollPanel.revalidate();
    }

    private void newTaskInput() {
        TextField name = new TextField("New task", "taskName");

        Panel durationPanel = getDurationPanel();
        Panel dateBeginPanel = getBeginDatePanel();
        Panel dateEndPanel = getEndDatePanel();

        CheckBox split = new CheckBox("Is splittable", "split");
        split.setSelected(false);

        Panel panel = new Panel(new GridLayout(0, 1), "taskInputPanel");
        panel.add(new Label("Task name:", "nameLabel"));
        panel.add(name);
        panel.add(new Label("Duration:", "durationLabel"));
        panel.add(durationPanel);
        panel.add(new Label("Processing period:", "processingPeriodLabel"));
        panel.add(dateBeginPanel);
        panel.add(dateEndPanel);
        panel.add(split);

        int result = JOptionPane.showConfirmDialog(null, panel, "Create new task",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String taskName = name.getText();

                int days = Integer.parseInt(((NumberTextField) durationPanel.getComponentByName("durationDays")).getText());
                int hours = Integer.parseInt(((NumberTextField) durationPanel.getComponentByName("durationHours")).getText());
                int minutes = Integer.parseInt(((NumberTextField) durationPanel.getComponentByName("durationMinutes")).getText());
                Duration dur = new Duration(days, hours, minutes);

                boolean splittable = split.isSelected();

                Date startDate = getDateFromStrings(((DateTextField) dateBeginPanel.getComponentByName("processingBeginDate")).getText(),
                        ((TimeTextField) dateBeginPanel.getComponentByName("processingBeginTime")).getText());
                Date endDate = getDateFromStrings(((DateTextField) dateEndPanel.getComponentByName("processingEndDate")).getText(),
                        ((TimeTextField) dateEndPanel.getComponentByName("processingEndTime")).getText());

                Task task = new Task(taskName, dur, splittable, startDate, endDate);
                task.validate();
                addNewTask(task);
            }

            catch (NegativeDurationDataException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration data entered!");
            }
            catch (InvalidTimeSpanStartEndException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch (DurationLongerThanProcessingTimeException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occured!\n " +
                        "Please try again and make sure to enter valid input data.");
                e.printStackTrace();
            }
        }
    }

    private Date getDateFromStrings(String dateString, String timeString) {
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6));
        int hour = Integer.parseInt(timeString.substring(0, 2));
        int minute = Integer.parseInt(timeString.substring(3));

        return new Date(year, month, day, hour, minute);
    }

    private Panel getBeginDatePanel() {
        DateTextField processingBeginDate = new DateTextField("processingBeginDate");
        processingBeginDate.setText("DD.MM.YYYY");
        TimeTextField processingBeginTime = new TimeTextField("processingBeginTime");
        processingBeginTime.setText("HH:MM");
        Panel dateBeginPanel = new Panel(new GridLayout(1, 0), "dateBeginPanel");
        dateBeginPanel.add(new Label("From", "dateBeginLabel"));
        dateBeginPanel.add(processingBeginDate);
        dateBeginPanel.add(processingBeginTime);

        return dateBeginPanel;
    }

    private Panel getEndDatePanel() {
        DateTextField processingEndDate = new DateTextField("processingEndDate");
        processingEndDate.setText("DD.MM.YYYY");
        TimeTextField processingEndTime = new TimeTextField("processingEndTime");
        processingEndTime.setText("HH:MM");
        Panel dateEndPanel = new Panel(new GridLayout(1, 0), "dateEndPanel");
        dateEndPanel.add(new Label("To", "dateEndLabel"));
        dateEndPanel.add(processingEndDate);
        dateEndPanel.add(processingEndTime);

        return dateEndPanel;
    }

    private Panel getDurationPanel() {
        NumberTextField durationDays = new NumberTextField("durationDays");
        durationDays.setText("Days");
        NumberTextField durationHours = new NumberTextField("durationHours");
        durationHours.setText("Hours");
        NumberTextField durationMinutes = new NumberTextField("durationMinutes");
        durationMinutes.setText("Minutes");
        Panel durationPanel = new Panel(new GridLayout(1, 0), "durationPanel");
        durationPanel.add(durationDays);
        durationPanel.add(durationHours);
        durationPanel.add(durationMinutes);

        return durationPanel;
    }

    private void newAppointmentInput() {
        TextField name = new TextField("New Appointment", "appointmentName");


    }
    private void newBlockerInput() {
        TextField name = new TextField("New Blocker", "blockerName");
    }

    private void setUpCalendar() throws NegativeDurationDataException {
        int cols = 8;
        GridBagConstraints c;
        Date[] dates = getWeekForDate(new Date());

        // Add top row of calendar.
        for (int col = 0; col < cols; ++col) {
            if (col < (cols - 1)) {
                c = getConstraints(col, 0, false, false);
            }
            else {
                c = getConstraints(col, 0, true, false);
            }
            if (col != 0) {
                calendarScrollPanel.add(new CalendarBorderTopPanel(dates[col - 1], TOPROWWIDTH, TOPROWHEIGHT), c);
            }
            else {
                calendarScrollPanel.add(new CalendarPanel(SIDEROWWIDTH, TOPROWHEIGHT), c);
            }
        }

        // Add side column of calendar.
        int index = 1;
        for (int hour = 0; hour < 24; ++hour) {
            for (int quarter = 0; quarter < 4; ++quarter) {
                if (!(hour == 23 && quarter == 3)) {
                    c = getConstraints(0, index++, false, false);
                }
                else {
                    c = getConstraints(0, index++, false, true);
                }
                try {
                    calendarScrollPanel.add(new CalendarBorderSidePanel(new SideTime(hour, (quarter * 15), new Duration(0, 0, 15)), SIDEROWWIDTH, SIDEROWHEIGHT), c);
                } catch (NegativeDurationDataException e) {
                    throw e;
                }
            }
        }

        calendarScrollPanel.revalidate();
    }

    private GridBagConstraints getConstraints(int x, int y, boolean isLastInRow, boolean isInLastRow) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = x;
        c.gridy = y;

        if (y == 0) {
            c.insets.top = 10;
        }
        if (x == 0) {
            c.insets.left = 10;
        }
        if (isLastInRow) {
            c.insets.right = 10;
            c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
        }
        if (isInLastRow) {
            c.insets.bottom = 10;
            c.gridheight = GridBagConstraints.REMAINDER;
            c.weighty = 1.0;
        }

        return c;
    }

    private Date[] getWeekForDate(Date date) {
        Date[] ret = new Date[7];
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int day = c.get(Calendar.DAY_OF_WEEK);
        if (day != 1) {
            day -= 2;
            ret[day] = date;
        }
        else {
            ret[6] = date;
            day = 6;
        }

        c.add(Calendar.DATE, -day);

        for (int index = 0; index < 7; ++index) {
            ret[index] = c.getTime();
            c.add(Calendar.DATE, 1);
        }

        return ret;
    }
}
