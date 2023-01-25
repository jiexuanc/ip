/**
 * Represents a to-do task.
 */
public class ToDos extends Task {

    protected ToDos(boolean status, String[] content) throws DukeException {
        super(status, content[0]);
        if (content[0].isEmpty()) {
            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
        }

    }

    protected String getTypeIcon() {
        return "T";
    }

    @Override
    protected String fileMessage() {
        return String.format("%s||%d||%s\n", getTypeIcon(), isDone ? 1 : 0, content);
    }
}
