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

        System.out.println("     ---------------------------------------");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("     ---------------------------------------");

        //Scans first command
        Scanner command = new Scanner(System.in);
        String cmd = command.nextLine();

        //Create handler for the 3 different commands
        Handler handle = new Handler();
        //Task[] tasks = new Task[100];
        ArrayList<Task> tasks = new ArrayList<>();

        int noOfTasks = 0;

        //Load previous list
        HardDisk hd = new HardDisk();
        noOfTasks = hd.load(tasks,noOfTasks);

        while (!cmd.equals("bye")) {
            try {
                if (!cmd.equals("list") && !cmd.contains("done") && !cmd.contains("delete")) {
                    tasks.add(noOfTasks, handle.manage(cmd));
                    System.out.println("     ---------------------------------------");
                    String toPrint = "       " + tasks.get(noOfTasks).toString();
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
                        System.out.println(tasks.get(count - 1).toString());
                        count++;
                    }
                    System.out.println("     ---------------------------------------");
                    cmd = command.nextLine();
                } else if (cmd.contains("done")){
                    int num = Integer.parseInt(cmd.replaceAll("\\D+", ""));
                    tasks.get(num - 1).markAsDone();
                    System.out.println("     ---------------------------------------");
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       " + tasks.get(num - 1).toString());
                    System.out.println("     ---------------------------------------");
                    hd.done(num);
                    cmd = command.nextLine();
                } else if (cmd.contains("delete")) {
                    int num = Integer.parseInt(cmd.replaceAll("\\D+", ""));
                    System.out.println("     ---------------------------------------");
                    System.out.println("     Noted. I've removed this task:");
                    System.out.println("       " + tasks.get(num - 1).toString());
                    noOfTasks--;
                    System.out.println("     Now you have " + noOfTasks + " tasks in the list.");
                    System.out.println("     ---------------------------------------");
                    tasks.remove(num-1);
                    hd.delete(num);
                    cmd = command.nextLine();
                }
            }
            catch (NullPointerException | IndexOutOfBoundsException e) {
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
