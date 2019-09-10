import java.io.IOException;

/**
 * Represents a type of command, where specific tasks are deleted.
 */
public class DeleteCommand extends Command {
    public DeleteCommand(String index) {
        type = Type.DONE;
        input = index;
    }

    /**
     * Handles the command and deletes the specific task from the list.
     *
     * @param tasks List of tasks
     * @param ui User interface
     * @param storage Storing of tasks
     * @throws DukeException If the number is not an integer (e.g a string)
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            int num = Integer.parseInt(input.replaceAll("\\D+", ""));
            String toDeleteTask = "     Noted. I've removed this task:\n";
            String toPrintTask = "       " + tasks.get(num - 1).toString() + "\n";
            tasks.delete(num - 1);
            storage.delete(num);
            String toShowTask = "     Now you have " + tasks.size() + " tasks in the list.";
            ui.showMessage(toDeleteTask + toPrintTask + toShowTask);
        } catch (NumberFormatException e) {
            throw new DukeException("     Not a valid number! Task does not exist, please try again.");
        }
    }
}
