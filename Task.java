public class Task {
    private final String taskId;
    private String name;
    private String description;
    
    // Constructor
    public Task(String taskId, String name, String description) {
        // Check task ID
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be longer than 10 characters");
        }
        
        // Set task ID (cannot be changed later)
        this.taskId = taskId;
        
        // Set name and description using setters for validation
        setName(name);
        setDescription(description);
    }
    
    // Get task ID
    public String getTaskId() {
        return taskId;
    }
    
    // Get name
    public String getName() {
        return name;
    }
    
    // Set name with validation
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters");
        }
        this.name = name;
    }
    
    // Get description
    public String getDescription() {
        return description;
    }
    
    // Set description with validation
    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
        this.description = description;
    }
}