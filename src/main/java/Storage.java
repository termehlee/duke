import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<Task> info = new ArrayList<>();

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

    //editing task as complete in text file
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

    //adding task to text file
    public static void write(String type, int done, String description, String by) throws IOException {
        File textFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt");
        FileWriter fw = new FileWriter(textFile, true);
        String line = (type + " | " + done + " | " + description + by);
        fw.append(line).append(String.valueOf('\n'));
        fw.close();
    }

    //removing task in text file
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

    //loading the text file when duke starts up
    public ArrayList<Task> load() throws IOException {
        return info;
    }
}
