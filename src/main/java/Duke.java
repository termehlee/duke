import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Starts loading the text file
     *
     * @param filePath The path where text file is stored
     * @throws DukeException If path is not found
     */
    public Duke(String filePath) throws DukeException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    /**
     * Executes the entire duke process
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) try {
            String fullCommand = ui.readCommand();
            ui.showLine();
            Command c = Parser.parse(fullCommand);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        } catch (DukeException | IOException e) {
            ui.showError(e.getMessage());
        } finally {
            ui.showLine();
        }
    }

    public static void main(String[] args) throws DukeException {
        new Duke("./data/duke.txt").run();
    }
}
