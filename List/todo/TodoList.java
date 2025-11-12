// File: TodoList.java
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<Task> tasks;

    // Constructor that initializes the task list
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    // Helper method to find a Task by its identifier
    private Task findTaskById(int identifier) {
        for (Task task : tasks) {
            if (task.getIdentifier() == identifier) {
                return task;
            }
        }
        return null;
    }

    // Method to add a Task
    public void addTask(Task task) {
        // Check for existing identifier
        if (findTaskById(task.getIdentifier()) != null) {
            throw new IllegalArgumentException(
                "Task with identifier " + task.getIdentifier() + " already exists in the list"
            );
        }

        // To satisfy the specific test case: 
        // try { todo.addTask(new Task("", 4)); } catch (Exception ex) { ... }
        // The Task class constructor allows "" but the list logic may need to prevent it.
        // We will enforce the validation here to ensure the error message matches the output.
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
             throw new IllegalArgumentException("Invalid task description");
        }
        
        tasks.add(task);
    }

    // Method to mark a task as done
    public boolean markTaskDone(int identifier) {
        Task task = findTaskById(identifier);
        if (task == null) {
            return false;
        }
        task.setDone(true);
        return true;
    }

    // Method to mark a task as not done
    public boolean undoTask(int identifier) {
        Task task = findTaskById(identifier);
        if (task == null) {
            return false;
        }
        task.setDone(false);
        return true;
    }

    // Method to mark all tasks as not done
    public void undoAll() {
        for (Task task : tasks) {
            task.setDone(false);
        }
    }

    // Method to mark all tasks as done
    public void completeAll() {
        for (Task task : tasks) {
            task.setDone(true);
        }
    }

    // Method to display all tasks
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
