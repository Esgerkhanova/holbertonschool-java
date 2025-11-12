import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getIdentifier() == task.getIdentifier()) {
                throw new IllegalArgumentException(
                    "Task with identifier " + task.getIdentifier() + " already exists in the list"
                );
            }
        }
        tasks.add(task);
    }

    public boolean markTaskDone(int identifier) {
        for (Task t : tasks) {
            if (t.getIdentifier() == identifier) {
                t.markDone();
                return true;
            }
        }
        return false;
    }

    public boolean undoTask(int identifier) {
        for (Task t : tasks) {
            if (t.getIdentifier() == identifier) {
                t.undo();
                return true;
            }
        }
        return false;
    }

    public void completeAll() {
        for (Task t : tasks) {
            t.markDone();
        }
    }

    public void undoAll() {
        for (Task t : tasks) {
            t.undo();
        }
    }

    public void listTasks() {
        for (Task t : tasks) {
            String status = t.isDone() ? "[X]" : "[ ]";
            System.out.println(status + "  Id: " + t.getIdentifier() + " - Description: " + t.getDescription());
        }
    }
}
