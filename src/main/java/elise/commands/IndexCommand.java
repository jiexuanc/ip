package elise.commands;

import java.io.IOException;

import elise.EliseException;
import elise.internal.Storage;
import elise.internal.TaskList;
import elise.internal.Ui;
import elise.tasks.Task;

/**
 * Command which involves finding a task by index and operating on it
 */
public class IndexCommand implements Command {

    private final int index;
    private final int code;

    /**
     * Constructor for Command of specified code and index.
     *
     * @param code unique code for type of command.
     * @param index index of list to perform action.
     */
    public IndexCommand(int code, int index) {
        assert code == 0 || code == 1 || code == 2 : "Wrong code";
        this.index = index;
        this.code = code;
    }
    @Override
    public String execute(Ui ui, TaskList taskList, Storage storage) throws EliseException, IOException {
        if (code == 0) {
            Task t = taskList.markDone(index);
            storage.write();
            return ui.markDoneMessage(t);
        } else if (code == 1) {
            Task t = taskList.markUndone(index);
            storage.write();
            return ui.markUndoneMessage(t);
        } else if (code == 2) {
            Task t = taskList.delete(index);
            storage.write();
            return ui.deleteMessage(t, taskList);
        } else {
            throw new EliseException("Invalid code.");
        }
    }

}
