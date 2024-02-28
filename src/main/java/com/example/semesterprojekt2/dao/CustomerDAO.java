package com.example.semesterprojekt2.dao;

import com.example.semesterprojekt2.model.Customer;
import com.example.semesterprojekt2.model.Log;
import com.example.semesterprojekt2.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Customer.
 */
public class CustomerDAO {

    /**
     * Adds a new customer to the database.
     * 
     * @param customer The customer to add.
     * @throws SQLException if there is an error during database access.
     */
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (name, email, phoneNumber) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhoneNumber());
            pstmt.executeUpdate();
        }
        Log logEntry = new Log(
            "Add Customer",
            LocalDateTime.now(),
            "Added customer: " + customer.getName()
        );
        new LogDAO().addLogEntry(logEntry);
    }

    /**
     * Retrieves a customer by their ID.
     * 
     * @param id The ID of the customer to retrieve.
     * @return An Customer object if found, null otherwise.
     * @throws SQLException if there is an error during database access.
     */
    public Customer getCustomerById(int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phoneNumber")
                    );
                }
            }
        }
        return null; // Customer not found
    }

    /**
     * Retrieves all customers from the database.
     * 
     * @return A List of Customer objects.
     * @throws SQLException if there is an error during database access.
     */
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber")
                ));
            }
        }
        return customers;
    }

    /**
     * Deletes a customer from the database by their ID.
     * 
     * @param id The ID of the customer to delete.
     * @throws SQLException if there is an error during database access.
     */
    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        Log logEntry = new Log(
                "Delete Customer",
                LocalDateTime.now(),
                "Deleted customer: " + id
        );
        new LogDAO().addLogEntry(logEntry);
    }
}
