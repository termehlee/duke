import java.io.IOException;

public class Handler {

    protected String cmd;

    public Task manage(String cmd) throws IOException {
        if (cmd.contains(" ")) {

            //get the first word
            String firstWord = cmd.substring(0, cmd.indexOf(" "));

            if (firstWord.equals("todo")) {
                String description = cmd.substring(cmd.indexOf(" ") + 1);
                return new Todo(description);
            } else {
                String description = cmd.substring(cmd.indexOf(" ") + 1, cmd.indexOf("/") - 1);
                String by = cmd.substring(cmd.indexOf("/") + 4);
                if (firstWord.equals("deadline")) {
                    return new Deadline(description, by);
                } else if (firstWord.equals("event")) {
                    return new Event(description, by);
                }
            }
        }
        return null;
    }
}