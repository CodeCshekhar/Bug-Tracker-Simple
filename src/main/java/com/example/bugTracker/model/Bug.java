package com.example.bugTracker.model;

import jakarta.persistence.*;

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // e.g., "Open", "In Progress", "Closed"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    // Default constructor
    public Bug() { }

    // Getters and setters

    public Long getId() {
        return id;
    }
    // Add this setter so BugService can call setId()
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
    // Add this setter so BugService can call setAssignedUser()
    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
