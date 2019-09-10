import java.io.*;
import java.util.ArrayList;

/**
 * Handles the any changes to the text file
 */
public class Storage {
    private static ArrayList<Task> info = new ArrayList<>();

    /**
     * Helps make sense of the text file, and creates the corresponding tasks
     *
     * @param filePath The path where text file is stored
     * @throws DukeException If the file is not found
     */
    public Storage(String filePath) throws DukeException {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String message;
            while ((message = br.readLine()) != null) {
                String firstWord = message.substring(0, message.indexOf(" "));
                if (firstWord.equals("T")) {
                    String[] command = message.split(" \\| ");
                    info.add(new Todo(command[2]));
                    if (command[1].equals("1")) {
                        info.get(info.size() - 1).isDone = true;
                    }
                } else if (firstWord.equals("D")) {
                    String[] command = message.split(" \\| ");
                    info.add(new Deadline(command[2], command[3]));
                    if (command[1].equals("1")) {
                        info.get(info.size() - 1).isDone = true;
                    }
                } else if (firstWord.equals("E")) {
                    String[] command = message.split(" \\| ");
                    info.add(new Event(command[2], command[3]));
                    if (command[1].equals("1")) {
                        info.get(info.size() - 1).isDone = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DukeException("     File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Marking the corresponding task as done by rewriting the entire text file
     * @param num The specific number of the task to be marked as done
     */
    void done(int num) {
        try {
            ArrayList<String> list = new ArrayList<String>();
            //get path of text file
            File textFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt");
            File parentDir = textFile.getParentFile();
            //if file does not exist, create parent file
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            FileReader fr = new FileReader(textFile);
            BufferedReader br = new BufferedReader(fr);
            String message;
            int currentNo = 0;
            //get current info in the file
            while ((message = br.readLine()) != null) {
                if (currentNo == num - 1) {
                    String[] command = message.split(" \\| ");
                    command[1] = "1";
                    if (command[0].equals("T")) {
                        list.add(command[0] + " | " + command[1] + " | " + command[2]);
                    } else {
                        list.add(command[0] + " | " + command[1] + " | " + command[2] + " | " + command[3]);
                    }
                } else {
                    list.add(message);
                }
                currentNo++;
            }
            FileWriter fw = new FileWriter(textFile);
            for (String line : list) {
                fw.append(line).append(String.valueOf('\n'));
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helps to add a new task to the text file
     *
     * @param type Type of command (i.e. todo/deadline/event)
     * @param done Represents if the task is done
     * @param description Description of the task (without the type of command)
     * @param by Date for task to be done by
     * @throws IOException If file is not found
     */
    public static void write(String type, int done, String description, String by) throws IOException {
        File textFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt");
        FileWriter fw = new FileWriter(textFile, true);
        String line = (type + " | " + done + " | " + description + by);
        fw.append(line).append(String.valueOf('\n'));
        fw.close();
    }

    /**
     * Helps to delete a specific task in the text file
     *
     * @param num The specific number of the task to be deleted
     */
    void delete(int num) {
        try {
            ArrayList<String> list = new ArrayList<String>();
            //get path of text file
            File textFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt");
            File parentDir = textFile.getParentFile();
            //if file does not exist, create parent file
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            FileReader fr = new FileReader(textFile);
            BufferedReader br = new BufferedReader(fr);
            String message;
            int currentNo = 0;
            //get current info in the file
            while ((message = br.readLine()) != null) {
                if (currentNo != num - 1) {
                    list.add(message);
                }
                currentNo++;
            }
            FileWriter fw = new FileWriter(textFile);
            for (String line : list) {
                fw.append(line).append(String.valueOf('\n'));
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads up the tesxt file when program is first started
     *
     * @return info List of tasks stored previously
     */
    public ArrayList<Task> load() {
        return info;
    }
}
