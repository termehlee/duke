import java.io.*;
import java.util.ArrayList;

public class HardDisk {

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
                if (currentNo == num-1) {
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

    //loading the text file when duke starts up
    int load(ArrayList<Task> tasks, int noOfTasks) throws IOException {
        try {
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
            while ((message = br.readLine()) != null) {
                String firstWord = message.substring(0, message.indexOf(" "));
                if (firstWord.equals("T")) {
                    String[] command = message.split(" \\| ");
                    tasks.add(noOfTasks, new Todo(command[2]));
                    if (command[1].equals("1")) {
                        tasks.get(noOfTasks).isDone = true;
                    }
                } else if (firstWord.equals("D")) {
                    String[] command = message.split(" \\| ");
                    tasks.add(noOfTasks, new Deadline(command[2], command[3]));
                    if (command[1].equals("1")) {
                        tasks.get(noOfTasks).isDone = true;
                    }
                } else if (firstWord.equals("E")) {
                    String[] command = message.split(" \\| ");
                    tasks.add(noOfTasks, new Event(command[2], command[3]));
                    if (command[1].equals("1")) {
                        tasks.get(noOfTasks).isDone = true;
                    }
                }
                noOfTasks++;
            }
            return noOfTasks;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noOfTasks;
    }
}
