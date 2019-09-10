import java.io.IOException;

public class DeleteCommand extends Command {
    public DeleteCommand(String index) {
        type = Type.DONE;
        input = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            int num = Integer.parseInt(input.replaceAll("\\D+", ""));
            tasks.delete(num - 1);
            storage.delete(num);
            String toDeleteTask = "     Noted. I've removed this task:\n";
            String toPrintTask = "       " + tasks.get(num - 1).toString() + "\n";
            String toShowTask = "     Now you have " + tasks.size() + " tasks in the list.";
            ui.showMessage(toDeleteTask + toPrintTask + toShowTask);
        } catch (NumberFormatException e) {
            throw new DukeException("     Not a valid number! Task does not exist, please try again.");
        }
    }
}
