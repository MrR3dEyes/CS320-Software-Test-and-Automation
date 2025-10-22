package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactService manages a list of contacts
 * Can add, delete, and update contacts
 */
public class ContactService {
    // HashMap stores contacts using contactId as the key
    private Map<String, Contact> contacts;
    
    /**
     * Creates a new empty contact service
     */
    public ContactService() {
        contacts = new HashMap<>();
    }
    
    /**
     * Adds a new contact to the service
     * Contact ID must be unique
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        String id = contact.getContactId();
        // Check if this ID is already used
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        
        // Add the contact to our list
        contacts.put(id, contact);
    }
    
    /**
     * Removes a contact from the service
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }
    
    /**
     * Updates the first name of an existing contact
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(firstName);
    }
    
    /**
     * Updates the last name of an existing contact
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setLastName(lastName);
    }
    
    /**
     * Updates the phone number of an existing contact
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setPhone(phone);
    }
    
    /**
     * Updates the address of an existing contact
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setAddress(address);
    }
    
    /**
     * Gets a contact by ID
     * Returns null if contact not found
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}