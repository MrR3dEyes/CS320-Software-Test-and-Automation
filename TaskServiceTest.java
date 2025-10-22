import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    
    private TaskService taskService;
    private Task testTask1;
    private Task testTask2;
    
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        testTask1 = new Task("12345", "Test Task 1", "First test task");
        testTask2 = new Task("67890", "Test Task 2", "Second test task");
    }
    
    @Test
    public void testAddTask() {
        taskService.addTask(testTask1);
        assertEquals(1, taskService.getTaskCount());
        assertEquals(testTask1, taskService.getTask("12345"));
    }
    
    @Test
    public void testAddMultipleTasks() {
        taskService.addTask(testTask1);
        taskService.addTask(testTask2);
        
        assertEquals(2, taskService.getTaskCount());
        assertEquals(testTask1, taskService.getTask("12345"));
        assertEquals(testTask2, taskService.getTask("67890"));
    }
    
    @Test
    public void testAddNullTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });
    }
    
    @Test
    public void testAddDuplicateId() {
        taskService.addTask(testTask1);
        
        Task duplicateTask = new Task("12345", "Duplicate", "Duplicate task");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(duplicateTask);
        });
    }
    
    @Test
    public void testDeleteTask() {
        taskService.addTask(testTask1);
        assertEquals(1, taskService.getTaskCount());
        
        taskService.deleteTask("12345");
        assertEquals(0, taskService.getTaskCount());
        assertNull(taskService.getTask("12345"));
    }
    
    @Test
    public void testDeleteTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("999");
        });
    }
    
    @Test
    public void testDeleteNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask(null);
        });
    }
    
    @Test
    public void testDeleteMultipleTasks() {
        taskService.addTask(testTask1);
        taskService.addTask(testTask2);
        assertEquals(2, taskService.getTaskCount());
        
        taskService.deleteTask("12345");
        assertEquals(1, taskService.getTaskCount());
        assertNull(taskService.getTask("12345"));
        assertNotNull(taskService.getTask("67890"));
        
        taskService.deleteTask("67890");
        assertEquals(0, taskService.getTaskCount());
        assertNull(taskService.getTask("67890"));
    }
    
    @Test
    public void testUpdateTaskName() {
        taskService.addTask(testTask1);
        
        taskService.updateTaskName("12345", "Updated Name");
        assertEquals("Updated Name", taskService.getTask("12345").getName());
    }
    
    @Test
    public void testUpdateNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("999", "New Name");
        });
    }
    
    @Test
    public void testUpdateNameNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName(null, "New Name");
        });
    }
    
    @Test
    public void testUpdateNameInvalid() {
        taskService.addTask(testTask1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("12345", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("12345", "123456789012345678901");
        });
    }
    
    @Test
    public void testUpdateTaskDescription() {
        taskService.addTask(testTask1);
        
        taskService.updateTaskDescription("12345", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("12345").getDescription());
    }
    
    @Test
    public void testUpdateDescriptionNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("999", "New Description");
        });
    }
    
    @Test
    public void testUpdateDescriptionNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription(null, "New Description");
        });
    }
    
    @Test
    public void testUpdateDescriptionInvalid() {
        taskService.addTask(testTask1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("12345", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("12345", "123456789012345678901234567890123456789012345678901");
        });
    }
    
    @Test
    public void testUpdateBothFields() {
        taskService.addTask(testTask1);
        
        taskService.updateTaskName("12345", "Updated Name");
        taskService.updateTaskDescription("12345", "Updated Description");
        
        Task updatedTask = taskService.getTask("12345");
        assertEquals("Updated Name", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
        assertEquals("12345", updatedTask.getTaskId());
    }
    
    @Test
    public void testTaskIdNotUpdatable() {
        taskService.addTask(testTask1);
        
        assertEquals("12345", taskService.getTask("12345").getTaskId());
        
        taskService.updateTaskName("12345", "New Name");
        taskService.updateTaskDescription("12345", "New Description");
        
        assertEquals("12345", taskService.getTask("12345").getTaskId());
    }
}