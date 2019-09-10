/**
 * Specific class for tasks involving todo
 */
public class Todo extends Task {

    protected String by;

    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the task into a string for printing
     *
     * @return toString String of the task to be printed out
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
