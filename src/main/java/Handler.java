import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Handler {

    public Task manage(String cmd) throws IOException {
        if (cmd.contains(" ")) {

            //get the first word
            String firstWord = cmd.substring(0, cmd.indexOf(" "));

            if (firstWord.equals("todo")) {
                String description = cmd.substring(cmd.indexOf(" ") + 1);
                String type = "T";
                String by = "";
                write(type,0, description, by);
                return new Todo(description);
            } else {
                String description = cmd.substring(cmd.indexOf(" ") + 1, cmd.indexOf("/") - 1);
                String by = cmd.substring(cmd.indexOf("/") + 4);
                if (firstWord.equals("deadline")) {
                    String type = "D";
                    String by1 = " | " + by;
                    write(type,0, description, by1);
                    return new Deadline(description, by);
                } else if (firstWord.equals("event")) {
                    String type = "E";
                    String by1 = " | " + by;
                    write(type,0, description, by1);
                    return new Event(description, by);
                }
            }
        }
        return null;
    }

    //adding task to text file
    public static void write(String type, int done, String description, String by) throws IOException {
        File textFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt");
        FileWriter fw = new FileWriter(textFile,true);
        String line = (type + " | " + done + " | " + description + by);
        fw.append(line).append(String.valueOf('\n'));
        fw.close();
    }
}