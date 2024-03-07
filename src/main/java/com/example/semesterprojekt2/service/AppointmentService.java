package com.example.semesterprojekt2.service;

import com.example.semesterprojekt2.dao.AppointmentDAO;
import com.example.semesterprojekt2.dao.CustomerDAO;
import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.model.Customer;
import jakarta.mail.MessagingException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO;

    public AppointmentService() {
        this.appointmentDAO = new AppointmentDAO();
    }

    private boolean isWithinBusinessHours(LocalDateTime start, LocalDateTime end) {
        // Define business hours and break time
        LocalTime businessStart = LocalTime.of(9, 0);
        LocalTime businessEnd = LocalTime.of(16, 0);
        LocalTime breakStart = LocalTime.of(11, 0);
        LocalTime breakEnd = LocalTime.of(12, 0);

        // Check if appointment is within business hours and not during break
        return !start.toLocalTime().isBefore(businessStart) &&
            !end.toLocalTime().isAfter(businessEnd) &&
            (end.toLocalTime().isBefore(breakStart) || start.toLocalTime().isAfter(breakEnd));
    }

    private boolean isValidDuration(long duration) {
        return duration == 15 || duration == 30 || duration == 45 || duration == 60;
    }

    /**
     * Creates a new appointment, ensuring no scheduling conflicts.
     * 
     * @param appointment The appointment to add.
     * @return boolean indicating success or failure.
     */
    public boolean createAppointment(Appointment appointment) {
        try {
            // Check if appointment time is within business hours (9-16) and not during break time (11-12)
            if (!isWithinBusinessHours(appointment.getStartTime(), appointment.getEndTime())) {
                return false;
            }

            // Check if the appointment duration is valid (15, 30, 45, or 60 minutes)
            long durationMinutes = java.time.Duration.between(appointment.getStartTime(), appointment.getEndTime()).toMinutes();
            if (!isValidDuration(durationMinutes)) {
                return false;
            }

            // Check for overlapping appointments
            if (appointmentDAO.hasOverlappingAppointment(appointment.getStartTime(), appointment.getEndTime())) {
                return false;
            }

            // If all checks pass, save the appointment
            appointmentDAO.addAppointment(appointment);
            Customer customer = CustomerDAO.getCustomerById(appointment.getCustomerId());
            NotificationService.mailConfirmationNotification(customer.getName(), appointment.getStartTime());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

   /**
     * Retrieves an appointment by its ID.
     * 
     * @param id The ID of the appointment.
     * @return The requested Appointment, or null if not found.
     */
    public Appointment getAppointmentById(int id) {
        try {
            return appointmentDAO.getAppointmentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates an existing appointment.
     * 
     * @param appointment The appointment with updated details.
     * @return boolean indicating success or failure.
     */
    public boolean updateAppointment(Appointment appointment) {
        try {
            // Similar validation as createAppointment, but exclude the current appointment in overlap check
            if (!isWithinBusinessHours(appointment.getStartTime(), appointment.getEndTime()) ||
                !isValidDuration(java.time.Duration.between(appointment.getStartTime(), appointment.getEndTime()).toMinutes()) ||
                appointmentDAO.hasOverlappingAppointmentExcludingSelf(appointment.getId(), appointment.getStartTime(), appointment.getEndTime())) {
                return false;
            }
    
            appointmentDAO.updateAppointment(appointment);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cancels (deletes) an appointment.
     * 
     * @param id The ID of the appointment to cancel.
     * @return boolean indicating success or failure.
     */
    public boolean cancelAppointment(int id) {
        try {
            appointmentDAO.denyAppointment(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lists all appointments within a given time range.
     * 
     * @param start The start of the time range.
     * @param end The end of the time range.
     * @return A list of appointments within the time range.
     */
    public List<Appointment> getAppointmentsInRange(LocalDateTime start, LocalDateTime end) {
        try {
            return appointmentDAO.getAppointmentsInRange(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
