// Author: Filip Arghir
// Date: October 1, 2025

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
    private AppointmentService service;

    // Set up new service before each test
    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    // Test adding an appointment
    @Test
    public void testAddAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        service.addAppointment("12345", futureDate, "Doctor appointment");
        
        Appointment appointment = service.getAppointment("12345");
        assertNotNull(appointment);
        assertEquals("12345", appointment.getAppointmentId());
    }

    // Test adding multiple appointments
    @Test
    public void testAddMultipleAppointments() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate1 = calendar.getTime();
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate2 = calendar.getTime();
        
        service.addAppointment("12345", futureDate1, "First appointment");
        service.addAppointment("67890", futureDate2, "Second appointment");
        
        assertNotNull(service.getAppointment("12345"));
        assertNotNull(service.getAppointment("67890"));
    }

    // Test that appointment ID must be unique
    @Test
    public void testAddDuplicateAppointmentId() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        service.addAppointment("12345", futureDate, "First appointment");
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment("12345", futureDate, "Second appointment");
        });
    }

    // Test deleting an appointment
    @Test
    public void testDeleteAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        service.addAppointment("12345", futureDate, "Doctor appointment");
        service.deleteAppointment("12345");
        
        assertNull(service.getAppointment("12345"));
    }

    // Test deleting an appointment that does not exist
    @Test
    public void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }

    // Test getting an appointment that does not exist
    @Test
    public void testGetNonexistentAppointment() {
        assertNull(service.getAppointment("99999"));
    }
}