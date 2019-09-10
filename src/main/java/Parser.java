public class Parser {
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
