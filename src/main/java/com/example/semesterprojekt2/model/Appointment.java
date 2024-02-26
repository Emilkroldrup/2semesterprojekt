package com.example.semesterprojekt2.model;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private int customerId;
    private int employeeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;

    public Appointment(int id, int customerId, int employeeId, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                '}';
    }
}
