// Author: Filip Arghir
// Date: October 1, 2025

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

    // Test successful appointment creation
    @Test
    public void testAppointmentCreation() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("12345", futureDate, "Doctor appointment");
        
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    // Test appointment ID cannot be null
    @Test
    public void testAppointmentIdNull() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    // Test appointment ID cannot be longer than 10 characters
    @Test
    public void testAppointmentIdTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    // Test appointment date cannot be null
    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    // Test appointment date cannot be in the past
    @Test
    public void testAppointmentDateInPast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Description");
        });
    }

    // Test description cannot be null
    @Test
    public void testDescriptionNull() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    // Test description cannot be longer than 50 characters
    @Test
    public void testDescriptionTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is way too long and exceeds the fifty character limit");
        });
    }

    // Test updating appointment date
    @Test
    public void testSetAppointmentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date newDate = calendar.getTime();
        
        appointment.setAppointmentDate(newDate);
        assertEquals(newDate, appointment.getAppointmentDate());
    }

    // Test updating description
    @Test
    public void testSetDescription() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("12345", futureDate, "Old description");
        
        appointment.setDescription("New description");
        assertEquals("New description", appointment.getDescription());
    }
}