package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Appointment;
import com.example.semesterprojekt2.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Appointment.
 */
public class AppointmentDAO {

    /**
     * Adds a new appointment to the database.
     * 
     * @param appointment The appointment to add.
     * @throws SQLException if there is an error during database access.
     */
    public void addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (customerId, employeeId, startTime, endTime, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getCustomerId());
            pstmt.setInt(2, appointment.getEmployeeId());
            pstmt.setObject(3, appointment.getStartTime());
            pstmt.setObject(4, appointment.getEndTime());
            pstmt.setString(5, appointment.getDescription());
            pstmt.executeUpdate();
        }
    }

    /**
     * Retrieves an appointment by its ID.
     * 
     * @param id The ID of the appointment to retrieve.
     * @return An Appointment object if found, null otherwise.
     * @throws SQLException if there is an error during database access.
     */
    public Appointment getAppointmentById(int id) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Appointment(
                            rs.getInt("id"),
                            rs.getInt("customerId"),
                            rs.getInt("employeeId"),
                            rs.getObject("startTime", LocalDateTime.class),
                            rs.getObject("endTime", LocalDateTime.class),
                            rs.getString("description")
                    );
                }
            }
        }
        return null; // Appointment not found
    }

    /**
     * Retrieves all appointments from the database.
     * 
     * @return A List of Appointment objects.
     * @throws SQLException if there is an error during database access.
     */
    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("id"),
                        rs.getInt("customerId"),
                        rs.getInt("employeeId"),
                        rs.getObject("startTime", LocalDateTime.class),
                        rs.getObject("endTime", LocalDateTime.class),
                        rs.getString("description")
                ));
            }
        }
        return appointments;
    }

    /**
     * Deletes an appointment from the database by its ID.
     * 
     * @param id The ID of the appointment to delete.
     * @throws SQLException if there is an error during database access.
     */
    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public boolean hasOverlappingAppointment(LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        String sql = "SELECT COUNT(*) FROM appointments WHERE (startTime < ? AND endTime > ?) OR (startTime < ? AND endTime > ?) OR (startTime >= ? AND endTime <= ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, endTime);
            pstmt.setObject(2, startTime);
            pstmt.setObject(3, endTime);
            pstmt.setObject(4, endTime);
            pstmt.setObject(5, startTime);
            pstmt.setObject(6, endTime);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean hasOverlappingAppointmentExcludingSelf(int appointmentId, LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        String sql = "SELECT COUNT(*) FROM appointments WHERE id != ? AND ((startTime < ? AND endTime > ?) OR (startTime < ? AND endTime > ?) OR (startTime >= ? AND endTime <= ?))";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            pstmt.setObject(2, endTime);
            pstmt.setObject(3, startTime);
            pstmt.setObject(4, endTime);
            pstmt.setObject(5, endTime);
            pstmt.setObject(6, startTime);
            pstmt.setObject(7, endTime);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE appointments SET customerId = ?, employeeId = ?, startTime = ?, endTime = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getCustomerId());
            pstmt.setInt(2, appointment.getEmployeeId());
            pstmt.setObject(3, appointment.getStartTime());
            pstmt.setObject(4, appointment.getEndTime());
            pstmt.setString(5, appointment.getDescription());
            pstmt.setInt(6, appointment.getId());
            pstmt.executeUpdate();
        }
    }
    
}
