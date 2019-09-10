import java.io.IOException;

/**
 * Represents the different type of commands that can be inputted into Duke.
 */
public class Command {
    protected Type type;
    protected String input;

    public enum Type {
        EXIT,
        LIST,
        TODO,
        DEADLINE,
        EVENT,
        DONE,
        FIND,
        DELETE
    }

    /**
     * Handles the different operations for each type of the commands.
     *
     * @param tasks List of tasks
     * @param ui User interface
     * @param storage Storing of tasks
     * @throws DukeException If command is not of the type
     * @throws IOException If file does not exist
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {
    }

    /**
     * Constructor to get the type of command
     *
     * @return type Type of the command
     */
    public Type getType() {
        return type;
    }

    /**
     * Ends the program if the command if of type Exit
     *
     * @return bool True denotes the end of the program, otherwise false
     */
    public boolean isExit() {
        return this.getType() == Type.EXIT;
    }

    /**
     * Constructor to get input given by the user
     *
     * @return input Input given by user
     */
    public String getInput() {
        return input;
    }
}
