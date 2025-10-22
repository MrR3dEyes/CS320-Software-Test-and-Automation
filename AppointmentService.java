// Author: Filip Arghir
// Date: October 1, 2025

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
    // List to store appointments
    private ArrayList<Appointment> appointments;

    // Constructor
    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    // Add a new appointment
    public void addAppointment(String appointmentId, Date appointmentDate, String description) {
        // Check if appointment ID already exists
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                throw new IllegalArgumentException("Appointment ID already exists");
            }
        }
        
        // Create and add new appointment
        Appointment newAppointment = new Appointment(appointmentId, appointmentDate, description);
        appointments.add(newAppointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        // Search for appointment and delete if found
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.remove(i);
                return;
            }
        }
        
        // If not found, throw exception
        throw new IllegalArgumentException("Appointment ID not found");
    }

    // Get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }
}