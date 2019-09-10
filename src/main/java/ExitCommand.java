public class ExitCommand extends Command {
    public ExitCommand() {
        type = Type.EXIT;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("     Bye. Hope to see you again soon!");
    }
}
