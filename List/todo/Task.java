// File: Task.java
public class Task {
    private String description;
    private boolean isDone;
    private final int identifier;

    // Constructor
    public Task(String description, int identifier) {
        this.description = description;
        this.identifier = identifier;
        this.isDone = false;
    }

    // Getter Accessor Methods
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getIdentifier() {
        return identifier;
    }

    // Setter for isDone (used by TodoList)
    public void setDone(boolean done) {
        this.isDone = done;
    }

    // Method to modify the task's description
    public void modifyDescription(String newDescription) {
        // Validation ensuring it’s neither null nor an empty string.
        if (newDescription == null || newDescription.trim().isEmpty()) {
            // Using IllegalArgumentException as per the likely intent of the test
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = newDescription;
    }

    // Overriding toString for easy display (as required by listTasks)
    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return String.format("%s  Id: %d - Description: %s", status, identifier, description);
    }
}
