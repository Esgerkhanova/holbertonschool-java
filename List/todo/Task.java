
public class Task {
    private String description;
    private boolean isDone;
    private final int identifier;

   
    public Task(String description, int identifier) {
        this.description = description;
        this.identifier = identifier;
        this.isDone = false;
    }

  
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getIdentifier() {
        return identifier;
    }


    public void setDone(boolean done) {
        this.isDone = done;
    }


    public void modifyDescription(String newDescription) {
   
        if (newDescription == null || newDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = newDescription;
    }


    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return String.format("%s  Id: %d - Description: %s", status, identifier, description);
    }
}
