package duke.task;

import duke.util.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class that encapsulates a Deadline task.
 */
public class Deadline extends Task {
    private LocalDate dueDate;

    /**
     * Returns a new Deadline object.
     * @param deadlineName The user input.
     */
    public Deadline(String deadlineName) throws DukeException {
        super(deadlineName, 9, deadlineName.indexOf("/by "));
        int start = deadlineName.indexOf("/by ");
        dueDate = LocalDate.parse(deadlineName.substring(start + 4));
    }

    /**
     * Returns a new Deadline object.
     * @param deadlineName The Deadline as written in the save file.
     * @param isDone Whether the task is done.
     */
    public Deadline(String deadlineName, boolean isDone) {
        super(deadlineName, isDone, 0, deadlineName.indexOf("(by:"));
        int start = deadlineName.indexOf("(by:") + 5;
        dueDate = LocalDate.parse(deadlineName.substring(start, start + 11),
                DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Overrides the toString method in Task.
     * @return The String representation of the Deadline object.
     */
    @Override
    public String toString() {
        return "[D]"
                + super.toString()
                + "(by: "
                + getDueDate().format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ")";
    }
}
