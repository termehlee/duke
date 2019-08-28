import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("     ____________________________________________________________");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("     ____________________________________________________________");

        Scanner command = new Scanner(System.in);
        String cmd = command.nextLine();

        Handler handle = new Handler();
        Task[] tasks = new Task[100];

        int noOfTasks = 0;

        while (!cmd.equals("bye")) {
            try {
                if (!cmd.equals("list") && !cmd.contains("done")) {
                    tasks[noOfTasks] = handle.manage(cmd);
                    System.out.println("     ---------------------------------------");
                    String toPrint = "       " + tasks[noOfTasks].toString();
                    System.out.println("     Got it. I've added this task:");
                    System.out.println(toPrint);
                    noOfTasks++;
                    System.out.println("     Now you have " + noOfTasks + " tasks in the list.");
                    System.out.println("     ---------------------------------------");
                    cmd = command.nextLine();
                } else if (cmd.equals("list")) {
                    int count = 1;
                    System.out.println("     ---------------------------------------");
                    System.out.println("     Here are the tasks in your list:");

                    //traverse through the whole list
                    while ((count - 1) < noOfTasks) {
                        System.out.print("     " + count + ".");
                        System.out.println(tasks[count - 1].toString());
                        count++;
                    }
                    System.out.println("     ____________________________________________________________");
                    cmd = command.nextLine();
                } else {
                    int num = Integer.parseInt(cmd.replaceAll("\\D+", ""));
                    tasks[num - 1].markAsDone();
                    System.out.println("     ---------------------------------------");
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       " + tasks[num - 1].toString());
                    System.out.println("     ---------------------------------------");
                    cmd = command.nextLine();
                }
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                if (cmd.equals("todo") || cmd.equals("deadline") || cmd.equals("event")) {
                    System.out.println("     ☹ OOPS!!! The description of a " + cmd + " cannot be empty.");
                } else {
                    System.out.println("     ☹ OOPS!! I'm sorry, but I don't know what that means :-(");
                }
                System.out.println("     ---------------------------------------");
                cmd = command.nextLine();
            }
        }
        System.out.println("     ---------------------------------------");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("     ---------------------------------------");
    }
}
