/**
 * Specific class for tasks involving deadline
 */
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Converts the task into a string for printing
     *
     * @return toString String of the task to be printed out
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String getBy() {
        return by;
    }
}
