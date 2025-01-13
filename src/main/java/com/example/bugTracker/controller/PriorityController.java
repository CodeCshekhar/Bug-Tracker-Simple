package com.example.bugTracker.controller;


import com.example.bugTracker.model.Priority;
import com.example.bugTracker.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priorities")
public class PriorityController {

    private final PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    // Create a new priority
    @PostMapping
    public Priority createPriority(@RequestBody Priority priority) {
        return priorityService.createPriority(priority);
    }

    // Get all priorities
    @GetMapping
    public List<Priority> getAllPriorities() {
        return priorityService.getAllPriorities();
    }

    // Get a priority by ID
    @GetMapping("/{id}")
    public Priority getPriorityById(@PathVariable Long id) {
        return priorityService.getPriorityById(id);
    }

    // Update a priority
    @PutMapping("/{id}")
    public Priority updatePriority(@PathVariable Long id, @RequestBody Priority priority) {
        return priorityService.updatePriority(id, priority);
    }

    // Delete a priority
    @DeleteMapping("/{id}")
    public void deletePriority(@PathVariable Long id) {
        priorityService.deletePriority(id);
    }
}
