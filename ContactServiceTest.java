package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the ContactService class
 * Makes sure adding, deleting, and updating contacts works
 */
class ContactServiceTest {
    
    private ContactService service;
    
    /**
     * Set up a fresh service before each test
     */
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }
    
    /**
     * Test adding a contact works
     */
    @Test
    void testAddContact() {
        Contact contact = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("123"));
    }
    
    /**
     * Test deleting a contact works
     */
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        service.addContact(contact);
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }
    
    /**
     * Test updating first name works
     */
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("123", "UpdatedFil");
        assertEquals("UpdatedFil", service.getContact("123").getFirstName());
    }
    
    /**
     * Test that you can't add two contacts with same ID
     */
    @Test
    void testAddDuplicateId() {
        Contact contact1 = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        Contact contact2 = new Contact("123", "Fil", "Arg", "5551234567", "123 Main St");
        
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }
}