import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
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

        //ArrayList<String> list = new ArrayList<>();

        Task[] tasks = new Task[100];

        int noOfTasks = 0;

        while (!cmd.equals("bye")) {
            if(!cmd.equals("list") && !cmd.contains("done")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     added: " + cmd);
                System.out.println("     ____________________________________________________________");
                tasks[noOfTasks] = new Task(cmd);
                noOfTasks += 1;
                cmd = command.nextLine();
            } else if (cmd.equals("list")) {
                int count = 1;
                System.out.println("     ____________________________________________________________");
                System.out.println("     Here are the tasks in your list");
                while(count-1 < noOfTasks) {
                    System.out.println("     " + count + "." + tasks[count-1].toString());
                    count++;
                }
                System.out.println("     ____________________________________________________________");
                cmd = command.nextLine();
            } else {
                int num = Integer.parseInt(cmd.replaceAll("\\D+", ""));
                tasks[num - 1].markAsDone();
                System.out.println("     ---------------------------------------");
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       " + tasks[num-1].toString());
                System.out.println("     ---------------------------------------");
                cmd = command.nextLine();
            }
        }
        System.out.println("     ---------------------------------------");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("     ---------------------------------------");
    }
}
