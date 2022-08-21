package logic;

import calendar.Appointment;
import calendar.Blocker;
import calendar.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that is mainly responsible for ordering and organizing the tasks in a useful manner.
 *
 * @author Markus Luethje
 */

public class OrganizingManager {

    private List<Blocker> blocker = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    final int ROWSLOTS = 92;
    final int COLUMNSLOTS = 7;
    private boolean[][] blockedSlots = new boolean[ROWSLOTS][COLUMNSLOTS];

    public OrganizingManager() {
        initArray();
    }

    private void initArray() {
        for (int rowIndex = 0; rowIndex < ROWSLOTS; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < COLUMNSLOTS; ++columnIndex) {
                blockedSlots[rowIndex][columnIndex] = false;
            }
        }
    }
}
