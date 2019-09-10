import java.io.IOException;

/**
 * Represents a type of command, where tasks are marked as done
 */
public class DoneCommand extends Command {
    public DoneCommand(String index) {
        type = Type.DONE;
        input = index;
    }

    /**
     * Handles the command and marks the specific task as done.
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
            if(num <= tasks.size()) {
                if (!tasks.get(num - 1).isDone) {
                    tasks.get(num - 1).markAsDone();
                    storage.done(num);
                    String toPrintDone = "     Nice! I've marked this task as done:\n";
                    String toPrintTask = "     " + tasks.get(num - 1).toString();
                    ui.showMessage(toPrintDone + toPrintTask);
                } else {
                    ui.showError("     This task is already done!");
                }
            } else {
                ui.showError("     Task does not exist, please try again.");
            }
        } catch (NumberFormatException e) {
            throw new DukeException("     Not a number! Task does not exist, please try again.");
        }
    }
}
