package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Employee;
import com.example.semesterprojekt2.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of the EmployeeDAO interface.
 */
public class EmployeeDAO implements IEmployeeDAO {

    /**
     * Adds a new employee to the database.
     * 
     * @param employee The employee to add.
     * @throws SQLException if there is an error during database access.
     */
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getPassword());
            pstmt.executeUpdate();
        }
    }

    /**
     * Retrieves an employee by their email.
     * 
     * @param email The email of the employee to retrieve.
     * @return An Employee object if found, null otherwise.
     * @throws SQLException if there is an error during database access.
     */
    public Employee getEmployeeByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM employees WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            email,
                            rs.getString("password")
                    );
                }
            }
        }
        return null; // Employee not found
    }
}
