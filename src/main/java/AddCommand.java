import java.io.IOException;

public class AddCommand extends Command {

    public AddCommand(Type command, String fullCommand) throws DukeException {

        input = fullCommand;

        boolean isEmpty = false;
        if(!fullCommand.contains(" ")){
            isEmpty = true;
        }
        if(command == Type.TODO) {
            if(isEmpty) {
                throw new DukeException ("     ☹ OOPS!!! The description of a todo cannot be empty.");
            }
            type = command;
        } else if (command == Type.DEADLINE) {
            if(isEmpty) {
                throw new DukeException("     ☹ OOPS!!! The description of a deadline cannot be empty.");
            }
            type = command;
        } else if (command == Type.EVENT) {
            if(isEmpty) {
                throw new DukeException("     ☹ OOPS!!! The description of an event cannot be empty.");
            }
            type = command;
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {

        String toAddTask = "     Got it. I've added this task:\n";
        String toShowTask = "     Now you have " + (tasks.size() + 1) + " tasks in the list.";

        switch (type) {
            case TODO:
                String description = getInput().substring(getInput().indexOf(" ") + 1);
                Storage.write("T",0, description, "");
                Task currTask = new Todo(description);
                tasks.getTasks().add(currTask);
                String toPrintTask = "       " + tasks.get(tasks.size()-1).toString() +"\n";
                ui.showMessage(toAddTask + toPrintTask + toShowTask);
                break;
            case DEADLINE:
                description = getInput().substring(getInput().indexOf(" ") + 1, getInput().indexOf("/") - 1);
                String by = getInput().substring(getInput().indexOf("/") + 4);
                DateTimeFormat format = new DateTimeFormat(by);
                by = " | " + format.toString();
                Storage.write("D",0, description, by);
                currTask = new Deadline(description,by);
                tasks.getTasks().add(currTask);
                toPrintTask = "       " + tasks.get(tasks.size()-1).toString() +"\n";
                ui.showMessage(toAddTask + toPrintTask + toShowTask);
                break;
            case EVENT:
                description = getInput().substring(getInput().indexOf(" ") + 1, getInput().indexOf("/") - 1);
                by = getInput().substring(getInput().indexOf("/") + 4);
                format = new DateTimeFormat(by);
                by = " | " + format.toString();
                Storage.write("E",0, description, by);
                currTask = new Event(description,by);
                tasks.getTasks().add(currTask);
                toPrintTask = "       " + tasks.get(tasks.size()-1).toString() +"\n";
                ui.showMessage(toAddTask + toPrintTask + toShowTask);
                break;
            default:
                throw new DukeException("     Unknown command!");
        }
    }
}
