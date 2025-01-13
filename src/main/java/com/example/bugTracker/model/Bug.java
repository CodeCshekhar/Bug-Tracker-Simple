package com.example.bugTracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")  // Ensure the correct column name
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "priority_id")  // Ensure the correct column name
    private Priority priority;
}
