import java.util.Scanner;

public class Ui {
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

    public void showLoadingError() {
        System.out.println("There are no tasks to be found!");
    }

    public void showLine() {
        System.out.println("     ---------------------------------------");
    }

    public String readCommand() {
        Scanner command = new Scanner(System.in);
        String cmd = command.nextLine();
        return cmd;
    }

    public void showError(String error) {
        System.out.println(error);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
