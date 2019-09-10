import java.io.IOException;

/**
 * Represents a type of command, where tasks of specific keywords are found
 */
public class FindCommand extends Command {
    public FindCommand(String word) {
        type = Type.DONE;
        input = word;
    }

    /**
     * Handles the command and find tasks that matches the specific keyword.
     * Returns error messages if no tasks are found.
     *
     * @param tasks List of tasks
     * @param ui User interface
     * @param storage Storing of tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String word = input.substring(input.indexOf(" ") + 1);
        String toFindTask = "     Here are the matching tasks in your list:\n";
        int count = 1;
        boolean isMatch = false;
        for (Task itr : tasks.getTasks()) {
            if (itr != null && itr.getDescription().contains(word)) {
                String toPrintTask = "     " + count + "." + itr.toString();
                ui.showMessage(toFindTask + toPrintTask);
                isMatch = true;
                count++;
            }
        }
        if(!isMatch && tasks.size() != 0) {
            ui.showMessage("     There are no matching keywords in your list!");
        } else if (tasks.size() == 0) {
            ui.showMessage("     Your list is empty.");
        }
    }
}

