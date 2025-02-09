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
    private User assignedUser; // Keep reference to User

    @JoinColumn(name = "user_id")
    private String assignedUserName; // Field to store the user's name

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    // Default constructor
    public Bug() { }

    // Getters and setters

    public Long getId() {
        return id;
    }

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
        return assignedUser; // Getter for assignedUser
    }
    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser; // Setter for assignedUser
    }

    public String getAssignedUserName() {
        return assignedUserName; // Getter for assignedUserName
    }
    public void setAssignedUserName(String assignedUserName) {
        this.assignedUserName = assignedUserName; // Setter for assignedUserName
    }

    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
