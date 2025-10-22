import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
    
    @Test
    public void testTaskCreation() {
        Task task = new Task("12345", "Test Task", "This is a test");
        
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test", task.getDescription());
    }
    
    @Test
    public void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "Test Description");
        });
    }
    
    @Test
    public void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "Test Description");
        });
    }
    
    @Test
    public void testTaskIdMaxLength() {
        Task task = new Task("1234567890", "Test Task", "Test Description");
        assertEquals("1234567890", task.getTaskId());
    }
    
    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Test Description");
        });
    }
    
    @Test
    public void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "123456789012345678901", "Test Description");
        });
    }
    
    @Test
    public void testNameMaxLength() {
        Task task = new Task("12345", "12345678901234567890", "Test Description");
        assertEquals("12345678901234567890", task.getName());
    }
    
    @Test
    public void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", null);
        });
    }
    
    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", "123456789012345678901234567890123456789012345678901");
        });
    }
    
    @Test
    public void testDescriptionMaxLength() {
        Task task = new Task("12345", "Test Task", "12345678901234567890123456789012345678901234567890");
        assertEquals("12345678901234567890123456789012345678901234567890", task.getDescription());
    }
    
    @Test
    public void testSetName() {
        Task task = new Task("12345", "Test Task", "Test Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }
    
    @Test
    public void testSetNameNull() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }
    
    @Test
    public void testSetNameTooLong() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("123456789012345678901");
        });
    }
    
    @Test
    public void testSetDescription() {
        Task task = new Task("12345", "Test Task", "Test Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
    
    @Test
    public void testSetDescriptionNull() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
    
    @Test
    public void testSetDescriptionTooLong() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("123456789012345678901234567890123456789012345678901");
        });
    }
    
    @Test
    public void testTaskIdNotUpdatable() {
        Task task = new Task("12345", "Test Task", "Test Description");
        assertEquals("12345", task.getTaskId());
        
        // Task ID should stay the same after updates
        task.setName("New Name");
        task.setDescription("New Description");
        assertEquals("12345", task.getTaskId());
    }
}