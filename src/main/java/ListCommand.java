public class ListCommand extends Command {
    public ListCommand() {
        type = Command.Type.LIST;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        int count = 1;
        if (tasks.size() > 0) {
            ui.showMessage("     Here are the tasks in your list:");
            for (Task task: tasks.getTasks()) {
                ui.showMessage("     " + count++ + "." + task.toString());
            }
        } else {
            ui.showError("     There are no tasks in your list yet!");
        }
    }
}
