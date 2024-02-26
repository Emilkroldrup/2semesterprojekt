package com.example.semesterprojekt2.model;

import java.time.LocalDateTime;

// This is only if we want to log every action in the system
public class Log {
    private int id;
    private String action;
    private LocalDateTime timestamp;
    private String details;

    public Log(String action, LocalDateTime timestamp, String details) {
        this.action = action;
        this.timestamp = timestamp;
        this.details = details;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                ", details='" + details + '\'' +
                '}';
    }
}
