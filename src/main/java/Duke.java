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

        ArrayList<String> list = new ArrayList<>();

        int noOfTasks = 0;

        while (!cmd.equals("bye")) {
            if(!cmd.equals("list")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     added: " + cmd);
                System.out.println("     ____________________________________________________________");
                list.add(cmd);
                noOfTasks++;
                cmd = command.nextLine();
            } else {
                int count = 1;
                System.out.println("     ____________________________________________________________");
                while(count-1 < list.size()) {
                    System.out.println("     " + count + ". " + list.get(count-1));
                    count++;
                }
                System.out.println("     ____________________________________________________________");
                cmd = command.nextLine();
            }
        }
        System.out.println("     ---------------------------------------");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("     ---------------------------------------");
    }
}
