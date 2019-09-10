/**
 * Helps to parse through the command and identify the type of command input by the user
 */
public class Parser {

    /**
     * Parses through the first word to create the corresponding command types
     *
     * @param fullCommand
     * @return the different types of commands after parsing
     * @throws DukeException If the command is not recognised
     */
    public static Command parse(String fullCommand) throws DukeException {

        String firstWord = null;
        if(fullCommand.contains(" ")) {
            firstWord = fullCommand.substring(0, fullCommand.indexOf(" "));
        }

        if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (firstWord.equals("todo")) {
            return new AddCommand(Command.Type.TODO,fullCommand);
        } else if (firstWord.equals("deadline")) {
            return new AddCommand(Command.Type.DEADLINE,fullCommand);
        } else if (firstWord.equals("event")) {
            return new AddCommand(Command.Type.EVENT,fullCommand);
        } else if (firstWord.equals("done")) {
            return new DoneCommand(fullCommand);
        } else if (firstWord.equals("find")) {
            return new FindCommand(fullCommand);
        } else if (firstWord.equals("delete")) {
            return new DeleteCommand(fullCommand);
        } else {
            throw new DukeException("     ☹ OOPS!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
