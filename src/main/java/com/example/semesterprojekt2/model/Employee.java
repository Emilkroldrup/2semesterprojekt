package com.example.semesterprojekt2.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String password;

    public Employee(String name, String email, String password) {
        this.name = name;
        setEmail(email);
        setPassword(password);
    }

    public Employee(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        setEmail(email); 
        setPassword(password); 
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.matches(".*[A-Z].*")) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain at least one uppercase letter");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                // Don't print the password for security reasons!! 
                '}';
    }
}
