package com.example.bugTracker.model;

import jakarta.persistence.*;

@Entity
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Default constructor
    public Priority() { }

    // Getters and setters

    public Long getId() {
        return id;
    }
    // Add this setter so PriorityService can call setId()
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
