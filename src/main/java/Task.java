/**
 * Represents the different types of tasks that can be inputted by the user
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Shows a tick or a cross to represent if task is done
     * @return
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or cross symbol
    }

    /**
     * Constructor to get the description of the task
     *
     * @return description Description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks the task as done
     */
    public void markAsDone () {
        this.isDone = true;
    }

    /**
     * Converts the task into a string for printing
     *
     * @return toString String of the task to be printed out
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }


}