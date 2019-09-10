/**
 * Specific class for tasks involving event
 */
public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Converts the task into a string for printing
     *
     * @return toString String of the task to be printed out
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    public String getAt() {
        return at;
    }
}
