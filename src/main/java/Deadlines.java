/**
 * Represent a task with a deadline.
 */
class Deadlines extends Task {
    private String end;
    protected Deadlines(String[] content) throws DukeException {
        super(content[0]);
        if (content.length == 1 || content[0].isEmpty()) {
            throw new DukeException("OOPS!!! Command should be in the format 'deadline [M] /by [M]'\n" +
                    "The description, [M] cannot be empty.");
        }
        String[] ends = content[1].split(" ", 2);
        if (!ends[0].equals("by") || ends.length == 1) {
            throw new DukeException("OOPS!!! Command should be in the format 'deadline [M] /by [M]'\n" +
                    "The description, [M] cannot be empty.");
        }
        end = ends[1];
    }

    /**
     * Returns the type icon dedicated to the deadline task.
     *
     * @return Type icon of deadline task
     */
    @Override
    protected String getTypeIcon() {
        return "D";
    }

    /**
     * @return String representation of the deadline task
     */
    @Override
    public String toString() {
        return super.toString() + "(by: " + end + ")";
    }


}
