package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Log;
import com.example.semesterprojekt2.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO {

    public void addLogEntry(Log log) throws SQLException {
        String sql = "INSERT INTO log_entries (action, timestamp, details) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, log.getAction());
            pstmt.setObject(2, log.getTimestamp());
            pstmt.setString(3, log.getDetails());
            pstmt.executeUpdate();
        }
    }
}
