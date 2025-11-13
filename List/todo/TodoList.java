
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<Task> tasks;

    
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    private Task findTaskById(int identifier) {
        for (Task task : tasks) {
            if (task.getIdentifier() == identifier) {
                return task;
            }
        }
        return null;
    }

    public void addTask(Task task) {
     
        if (findTaskById(task.getIdentifier()) != null) {
            throw new IllegalArgumentException(
                "Task with identifier " + task.getIdentifier() + " already exists in the list"
            );
        }

        
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
             throw new IllegalArgumentException("Invalid task description");
        }
        
        tasks.add(task);
    }

    public boolean markTaskDone(int identifier) {
        Task task = findTaskById(identifier);
        if (task == null) {
            return false;
        }
        task.setDone(true);
        return true;
    }

  
    public boolean undoTask(int identifier) {
        Task task = findTaskById(identifier);
        if (task == null) {
            return false;
        }
        task.setDone(false);
        return true;
    }


    public void undoAll() {
        for (Task task : tasks) {
            task.setDone(false);
        }
    }

   
    public void completeAll() {
        for (Task task : tasks) {
            task.setDone(true);
        }
    }


    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
