package com.example.semesterprojekt2.model;

public class Treatment {
    private int id;
    private String name;
    private int duration; // Duration in minutes
    private String description;

    public Treatment(int id, String name, int duration, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
}
