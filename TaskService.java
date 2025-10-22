import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> taskList;
    
    // Constructor
    public TaskService() {
        taskList = new ArrayList<Task>();
    }
    
    // Add a task
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        
        // Check if task ID already exists
        for (Task t : taskList) {
            if (t.getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("Task ID already exists");
            }
        }
        
        taskList.add(task);
    }
    
    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskId().equals(taskId)) {
                taskList.remove(i);
                return;
            }
        }
        
        throw new IllegalArgumentException("Task not found");
    }
    
    // Update task name
    public void updateTaskName(String taskId, String name) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                task.setName(name);
                return;
            }
        }
        
        throw new IllegalArgumentException("Task not found");
    }
    
    // Update task description
    public void updateTaskDescription(String taskId, String description) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                task.setDescription(description);
                return;
            }
        }
        
        throw new IllegalArgumentException("Task not found");
    }
    
    // Get a task by ID (for testing)
    public Task getTask(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }
    
    // Get number of tasks (for testing)
    public int getTaskCount() {
        return taskList.size();
    }
}