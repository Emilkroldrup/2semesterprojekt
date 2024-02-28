package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Log;
import com.example.semesterprojekt2.model.Treatment;
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
public class TreatmentDAO {

    /**
     * Adds a new treatment to the database.
     * 
     * @param treatment The treatment to add.
     * @throws SQLException if there is an error during database access.
     */
    public void addTreatment(Treatment treatment) throws SQLException {
        String sql = "INSERT INTO treatments (name, duration, description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, treatment.getName());
            pstmt.setInt(2, treatment.getDuration());
            pstmt.setString(3, treatment.getDescription());
            pstmt.executeUpdate();
        }
        Log logEntry = new Log(
                "Add Treatment",
                LocalDateTime.now(),
                "Added Treatment: " + treatment.getId()
        );
        new LogDAO().addLogEntry(logEntry);
    }

    /**
     * Retrieves a treatment by its ID.
     * 
     * @param id The ID of the treatment to retrieve.
     * @return A Treatment object if found, null otherwise.
     * @throws SQLException if there is an error during database access.
     */
    public Treatment getTreatmentById(int id) throws SQLException {
        String sql = "SELECT * FROM treatments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Treatment(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("duration"),
                            rs.getString("description")
                    );
                }
            }
        }
        return null; // Treatment not found
    }

    /**
     * Retrieves all treatments from the database.
     * 
     * @return A List of Treatment objects.
     * @throws SQLException if there is an error during database access.
     */
    public List<Treatment> getAllTreatments() throws SQLException {
        List<Treatment> treatments = new ArrayList<>();
        String sql = "SELECT * FROM treatments";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                treatments.add(new Treatment(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("duration"),
                        rs.getString("description")
                ));
            }
        }
        return treatments;
    }

    /**
     * Deletes a treatment from the database by its ID.
     * 
     * @param id The ID of the treatment to delete.
     * @throws SQLException if there is an error during database access.
     */
    public void deleteTreatment(int id) throws SQLException {
        String sql = "DELETE FROM treatments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        Log logEntry = new Log(
                "Delete Treatment",
                LocalDateTime.now(),
                "Deleted Treatment: " + id
        );
        new LogDAO().addLogEntry(logEntry);
    }
}
