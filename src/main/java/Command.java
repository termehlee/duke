import java.io.IOException;

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

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {

    }

    public Type getType() {
        return type;
    }

    public boolean isExit() {
        return this.getType() == Type.EXIT;
    }

    public String getInput() {
        return input;
    }
}
