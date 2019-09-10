import java.util.ArrayList;

/**
 * Represents the list of all the tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> list) {
        tasks = new ArrayList<>(list);
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor to access the tasks in the list
     *
     * @return tasks Tasks in the list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Constructor to return the number of tasks in the list
     *
     * @return size Size of the list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Constructor to access a specific task in the list
     *
     * @param index The index of specific task wanted in the list
     * @return the task at the specific index
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Constructor to delete a specific task in the list
     *
     * @param index The index of specific task to delete in the list
     */
    public void delete(int index) {
        tasks.remove(index);
    }
}
