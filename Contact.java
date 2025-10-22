package contact;

/**
 * Contact class stores information about a person
 * Contact ID cannot be changed after creation
 */
public class Contact {
    private final String contactId;  // Cannot be changed
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    /**
     * Creates a new contact with all required information
     * All fields are checked to make sure they meet requirements
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Check contactId - must exist and be 10 characters or less
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        
        // Check firstName - must exist and be 10 characters or less
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        
        // Check lastName - must exist and be 10 characters or less
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        
        // Check phone - must exist and be exactly 10 digits
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        
        // Check address - must exist and be 30 characters or less
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        // Save all the information
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    // Methods to get contact information
    public String getContactId() {
        return contactId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    // Methods to update contact information (contactId cannot be changed)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }
    
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.phone = phone;
    }
    
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}