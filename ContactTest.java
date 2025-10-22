package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Contact class
 * Makes sure all the rules are followed
 */
class ContactTest {
    
    /**
     * Test creating a valid contact
     */
    @Test
    void testContactCreation() {
        Contact contact = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("Fil", contact.getFirstName());
    }
    
    /**
     * Test that contact ID cannot be too long
     */
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Fil", "Arg", "5551234567", "123 Main St");
        });
    }
    
    /**
     * Test that first name cannot be too long
     */
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "VeryLongFirstName", "Arg", "5551234567", "123 Main St");
        });
    }
    
    /**
     * Test that phone must be exactly 10 digits
     */
    @Test
    void testPhoneWrongLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Fil", "Arg", "555123", "123 Main St");
        });
    }
    
    /**
     * Test updating first name works correctly
     */
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        contact.setFirstName("NewName");
        assertEquals("NewName", contact.getFirstName());
    }
}