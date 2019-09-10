/**
 * Represents a type of command, where the program ends.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        type = Type.EXIT;
    }

    /**
     * Handles the command and closes the entire program
     *
     * @param tasks List of tasks
     * @param ui User interface
     * @param storage Storing of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("     Bye. Hope to see you again soon!");
    }
}
