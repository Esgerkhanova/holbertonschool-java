// File: Task.java
public class Task {
    private String description;
    private boolean isDone;
    private final int identifier; // identifier should be final as it's set in the constructor

    // Constructor
    public Task(String description, int identifier) {
        this.description = description;
        this.identifier = identifier;
        this.isDone = false; // Default state is not done
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
        if (newDescription == null || newDescription.trim().isEmpty()) {
            // Using the custom exception for clarity, though an IllegalArgumentException is also fine
            throw new InvalidTaskDescriptionException("Invalid task description");
        }
        this.description = newDescription;
    }

    // Overriding toString for easy display (as required by listTasks)
    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        // Note: The example output has a space before Id:
        return String.format("%s  Id: %d - Description: %s", status, identifier, description);
    }
}
