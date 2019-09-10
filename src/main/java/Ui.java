import java.util.Scanner;

/**
 * Represents the user interface and interactions with the user
 */
public class Ui {

    /**
     * Prints the welcome message upon starting Duke
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("     ---------------------------------------");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("     ---------------------------------------");
    }

    /**
     * Prints an error when there are no tasks available
     */
    public void showLoadingError() {
        System.out.println("There are no tasks to be found!");
    }

    /**
     * Prints the boundary line
     */
    public void showLine() {
        System.out.println("     ---------------------------------------");
    }

    /**
     * Helps to read in the user input
     *
     * @return cmd Input by the user
     */
    public String readCommand() {
        Scanner command = new Scanner(System.in);
        String cmd = command.nextLine();
        return cmd;
    }

    /**
     * Prints error message
     *
     * @param error Error shown by the system
     */
    public void showError(String error) {
        System.out.println(error);
    }

    /**
     * Prints wanted message
     *
     * @param message Message customised accordingly
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
